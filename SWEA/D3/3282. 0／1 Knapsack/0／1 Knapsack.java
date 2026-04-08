import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static class Thing {
		int weight, value;

		public Thing(int weight, int value) {
			super();
			this.weight = weight;
			this.value = value;
		}
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			sb.append("#").append(tc).append(" ");
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			
			Thing[] things = new Thing[n];
			int[] dp = new int[k+1];
			for(int i=0; i<n; i++) {
				st = new StringTokenizer(br.readLine());
				int weight = Integer.parseInt(st.nextToken());
				int value = Integer.parseInt(st.nextToken());
				
				things[i] = new Thing(weight, value);
			}
			
			for(int i=0; i<n; i++) {
				for(int j=k; j>=things[i].weight; j--) {
					dp[j] = Math.max(dp[j], dp[j-things[i].weight]+ things[i].value );
				}
			}
			sb.append(dp[k]).append("\n");
			
			
		}
		System.out.println(sb);
	}
}
