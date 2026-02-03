import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			sb.append("#").append(tc).append(" ");
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int[] bags = new int[N];
			
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++) {
				bags[i] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(bags);
			
			// 투포인터
			int start = 0;
			int end = N-1;
			int sum; // 
			int max = -1;
			while(start < end) {
				sum = bags[start] + bags[end];
				if(sum <= M) {
					if(sum == M) { // 합이 M 같다면 종료한다
						max = M;
						break;
					}
					if(sum > max) // 합이 max보다 크다면 max 업데이트 
						max = sum;
					++start; // 아직 sum이 M보다 작으므로 좌측 포인터를 우측으로 민다.
				}
				else {
					--end; // sum이 M보다 크므로 우측 포인터를 좌측으로 민다.
				}
				
			}
			sb.append(max).append("\n");
		}
		System.out.println(sb);
	}
}
