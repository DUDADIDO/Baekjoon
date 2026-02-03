import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long[] dp = new long[101];
		dp[1] = 1;
		dp[2] = 1;
		dp[3] = 1;
		dp[4] = 2;
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			int N = Integer.parseInt(br.readLine());
			long answer = 0;
			if(dp[N] > 0) {
				answer = dp[N];
			}
			else {
				for(int i=4; i<=N; i++) {
					dp[i] = dp[i-2] + dp[i-3];
				}
				answer = dp[N];
			}
			
			System.out.println(answer);
		
		}
	}
}


/*import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long[] dp = new long[101];
		dp[1] = 1;
		dp[2] = 1;
		dp[3] = 1;
		dp[4] = 2;
		dp[5] = 2;
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			long answer = 0;
			if (dp[N] > 0) {
				answer = dp[N];
			}
			else {
				for (int i = 6; i <= N; i++) {
					dp[i] = dp[i - 1] + dp[i - 5];
				}
				answer = dp[N];
			}
			System.out.println(answer);
		}
	}
}*/