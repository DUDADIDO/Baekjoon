import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int testCase = Integer.parseInt(br.readLine());

        for(int T=0; T<testCase; T++) {
            int n = Integer.parseInt(br.readLine());
            int[][] arr = new int[n][2];
            for(int i=0; i<n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                arr[i][0] = Integer.parseInt(st.nextToken());
                arr[i][1] = Integer.parseInt(st.nextToken());
            }

            // 서류 등수를 기준으로 오름차순 정렬 해뒀기 때문에 서류 점수는 고려하지 않아도 됨. (앞의 사람이 이미 서류 등수는 더 좋기 때문에)
            // 면접 등수를 봐야 하는데 앞선 사람보다 면접 등수까지 더 안좋으면 그 사람은 서류등수 + 면접등수 두개 다 안좋기 때문에 선발되지 않는다.
            Arrays.sort(arr, (o1, o2) -> {
                return o1[0] - o2[0];
            }); // 2차원 배열의 첫 번째 수를 기준으로 오름차순 정렬
//            for(int i=0; i<n; i++) {
//                System.out.print(arr[i][0] + " ");
//                System.out.print(arr[i][1] + " ");
//                System.out.println();
//            }
            int best = Integer.MAX_VALUE;
            int cnt = 0;
            for(int i=0; i<n; i++) {
                if(arr[i][1] < best) {
                    cnt++;
                    best = arr[i][1];
                }
            }
            sb.append(cnt).append("\n");
        }
        System.out.print(sb);
    }
}