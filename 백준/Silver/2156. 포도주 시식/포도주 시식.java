import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());

		List<Integer> list = new ArrayList<>();
		int[] dp = new int[n];
		int[] arr = new int[n];
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		if(n == 1) {
			System.out.println(arr[0]);
		}
		else if(n==2) {
			System.out.println(arr[0]+arr[1]);
		}
		else {
			dp[0] = arr[0];
			dp[1] = arr[0] + arr[1];
			dp[2] = Math.max(dp[1], Math.max(arr[1]+arr[2], arr[0]+arr[2]));
			for(int i=3; i<n; i++) {
				// 이번잔은 0잔 - dp[i-1](전잔)에서 값이 이어짐
				// 이번잔은 1잔 - dp[i-2](전전잔)에서 값이 이어짐 // 이번잔이 1잔이니 전전잔에서 이번잔 값 더해줌
				// 이번잔은 2잔 - dp[i-3](전전전잔)에서 값이 이어짐  이번잔이 2잔 연속이니, 3잔 전 시점에서 이번잔, 전잔 값 더해줌
				dp[i] = Math.max(dp[i-1], Math.max(dp[i-2]+arr[i], dp[i-3]+arr[i-1]+arr[i]));
			}
			System.out.println(dp[n-1]);
		}

	}
}
