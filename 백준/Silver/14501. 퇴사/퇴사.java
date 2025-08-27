import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine()); // 남은 근무 일수
        int[] dp = new int[n+1]; // dp그래프
        int[][] jobs = new int[n+1][2]; // 상담 리스트
        dp[0] = 0;

        for(int i=1; i<=n; i++) {
            st = new StringTokenizer(br.readLine());
            jobs[i][0] = Integer.parseInt(st.nextToken()); // 상담 기간
            jobs[i][1] = Integer.parseInt(st.nextToken()); // 상담 보수
        }

        for(int i=1; i<=n; i++) {
            dp[i] = Math.max(dp[i-1], dp[i]);

            int duration = jobs[i][0];
            int pay = jobs[i][1];
            int finishDay = i + duration - 1;

            if(finishDay <= n) { // 해당 상담이 남은 근무기간 내 끝난다면
                int newPay = dp[i-1] + pay; // 새로운 보수는 이전일 까지의 일 + 새로운 보수
                dp[finishDay] = Math.max(dp[finishDay], newPay); // 상담이 끝나는 일의 최종 보수는 해당 일까지의 기존 보수 vs 이 상담을 받알을 때 새로 계산한 보수
            }
        }

        System.out.println(dp[n]);
    }
}