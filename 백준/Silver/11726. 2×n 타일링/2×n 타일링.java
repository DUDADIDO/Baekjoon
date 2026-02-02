import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		int[] dp = new int[1001];
		Scanner sc = new Scanner(System.in);
		dp[1] = 1;
		dp[2] = 2;
		int n = sc.nextInt();
		for(int i=3; i<=n; i++) {
			dp[i] = (dp[i-1] + dp[i-2]) % 10007;
		}
		System.out.println(dp[n]);
	}
}
