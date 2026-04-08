import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static class Thing {
		int weight, value;

		public Thing(int weight, int value) {
			super();
			this.weight = weight;
			this.value = value;
		}
		
	}
	static Thing[] things;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		things = new Thing[n];
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			int weight = Integer.parseInt(st.nextToken());
			int value = Integer.parseInt(st.nextToken());
			
			things[i] = new Thing(weight, value);
		}
		
		int[] dp = new int[k+1];
		
		for(int i=0; i<n; i++) {
			for(int j=k; j>=things[i].weight; j--) {
				dp[j] = Math.max(dp[j], dp[j-things[i].weight]+things[i].value);
			}
		}
		System.out.println(dp[k]);
	}
}
