import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		int[][] dp = new int[101][10];
		Scanner sc = new Scanner(System.in);
		long answer = 0;
		int n = sc.nextInt();
		for(int i=1; i<10; i++) {
			dp[1][i] = 1;
		}
		for(int i=2; i<=n; i++) {
			dp[i][0] = dp[i-1][1];
			dp[i][9] = dp[i-1][8];
			for(int j=1; j<=8; j++) {
				dp[i][j] = (dp[i-1][j-1] + dp[i-1][j+1]) % 1000000000;
			}
		}
		for(int i=0; i<10; i++) {
//			System.out.println("dp["+n+"]["+i+"]: " + dp[n][i]);
			answer = (answer + dp[n][i]) % 1000000000;
		}
		System.out.println(answer);
	}
}
