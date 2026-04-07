import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int[][] pascal = new int[31][31];
		for(int i=0; i<=30; i++) {
			for(int j=0; j<=i; j++) {
				if(j == 0 || j == i) pascal[i][j] = 1;
				else {
					pascal[i][j] = pascal[i-1][j-1] + pascal[i-1][j];
				}
			}
		}
		for(int tc=0; tc<T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			System.out.println(pascal[m][n]);
			
		}
	}
}
