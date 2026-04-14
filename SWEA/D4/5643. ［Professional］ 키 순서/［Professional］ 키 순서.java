import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	static final int INF = 10000000;
	public static void main(String[] args) throws IOException {
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			sb.append("#").append(tc).append(" ");
			int n = Integer.parseInt(br.readLine());
			int m = Integer.parseInt(br.readLine());
			int cnt = 0;
			int[][] graph = new int[n+1][n+1];
			for(int i=0; i<=n; i++)
				Arrays.fill(graph[i], INF);
			for(int i=0; i<=n; i++) 
				graph[i][i] = 0;
			
			for(int i=0; i<m; i++) {
				st = new StringTokenizer(br.readLine());
				int u = Integer.parseInt(st.nextToken());
				int v = Integer.parseInt(st.nextToken());
				
				graph[u][v] = 1;
			}
			
			for(int i=1; i<=n; i++) {
				for(int j=1; j<=n; j++) {
					for(int k=1; k<=n; k++) {
						graph[j][k] = Math.min(graph[j][k], graph[j][i]+graph[i][k]);
					}
				}
			}
			
			for(int i=1; i<=n; i++) {
				int row = 0;
				int col = 0;
				
				for(int r=1; r<=n; r++) {
					if(graph[r][i] > 0 && graph[r][i] < INF) {
						row++;
					}
					if(graph[i][r] > 0 && graph[i][r] < INF) {
						col++;
					}
				}
				if(row + col == n-1) {
					cnt++;
				}
			}
			
			
			sb.append(cnt).append("\n");
			
			
			
			
			
			
			
		}
		System.out.println(sb);
		
	}
}
