import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static int N, X, M, sum, maxSum;
    static int[][] reports;
    static int[] pm, arr, maxArr;
    static StringBuilder sb = new StringBuilder();
    static void dfs(int L) {
        if(L == N) {
            if(sum > maxSum) {
                maxSum = sum;
                maxArr = pm.clone();
            }
            return;
        }
        else {
            for(int i=0; i<=X; i++) {
                pm[L] = i;
                sum += i;

                boolean isPossible = true;
                for(int j=0; j<M; j++) {
                    if(L+1 == reports[j][1]) {
                        int sumA = 0;
                        int start = reports[j][0];
                        int end = reports[j][1];
                        for(int a=start-1; a<end; a++) {
                            sumA += pm[a];
                        }
                        if(sumA != reports[j][2]) {
                            isPossible = false;
                            break;
                            }
                    }
                }
                if(isPossible) {
                    dfs(L+1);
                }
                sum -= i;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int tc=1; tc<=T; tc++) {
            sb.append("#").append(tc).append(" ");
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            X = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            reports = new int[M][3];

            pm = new int[N];
            sum = 0;
            maxSum = -1;
            for(int i=0; i<M; i++) {
                st = new StringTokenizer(br.readLine());
                reports[i][0] = Integer.parseInt(st.nextToken());
                reports[i][1] = Integer.parseInt(st.nextToken());
                reports[i][2] = Integer.parseInt(st.nextToken());
            }

            dfs(0);

            if(maxSum == -1) {
                sb.append("-1\n");
            }
            else {
                for(int num : maxArr) {
                    sb.append(num).append(" ");
                }
                sb.append("\n");
            }
        }
        System.out.println(sb);
    }
}
