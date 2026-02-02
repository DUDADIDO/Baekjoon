import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[][][] dp;
	static int recur(int a, int b, int c) {
		if(a<=0 || b<=0 || c<=0)
			return 1;
		if(a>20 || b>20 || c>20)
			return recur(20, 20, 20);
		if(dp[a][b][c] != 0)
			return dp[a][b][c];
		if(a<b && b<c)
			return dp[a][b][c] = recur(a, b, c-1) + recur(a, b-1, c-1) - recur(a, b-1, c);
		return dp[a][b][c] = recur(a-1, b, c) + recur(a-1, b-1, c) + recur(a-1, b, c-1) - recur(a-1, b-1, c-1);
		
	}
	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		dp = new int[21][21][21];
		
		int a = 0;
		int b = 0;
		int c = 0;
		while(true) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			if(a == -1 && b == -1 && c == -1) {
				break;
			}
			int result = recur(a, b, c);
			sb.append("w(").append(a).append(", ").append(b)
			.append(", ").append(c).append(") = ").append(result).append("\n");
		}
		System.out.println(sb);
	}
}
