import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] nums = new int[n+1];
		for(int i=1; i<=n; i++) {
			nums[i] = Integer.parseInt(br.readLine());
		}
		int[][] dp = new int[n+1][3];
		dp[1][1] = nums[1];
		for(int i=2; i<=n; i++) {
			dp[i][2] = dp[i-1][1] + nums[i];
			dp[i][1] = Math.max(dp[i-2][1], dp[i-2][2]) + nums[i];
		}
		int max = Math.max(dp[n][1], dp[n][2]);
		System.out.println(max);
	}
}
