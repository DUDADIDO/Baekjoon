import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int[][] map;
	static final int INF = 10000000;
	public static void main(String[] args) throws IOException {
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			sb.append("#").append(tc).append(" ");
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			map = new int[n][n];
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if(i != j && map[i][j] == 0) {
						map[i][j] = INF;
					}
				}
			}
			
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					for(int k=0; k<n; k++) {
						map[j][k] = Math.min(map[j][k], map[j][i] + map[i][k]);
					}
				}
			}
//			for(int i=0; i<n; i++) {
//				for(int j=0; j<n; j++) {
//					System.out.print(map[i][j] + " ");
//				}
//				System.out.println();
//			}
			
			int min = Integer.MAX_VALUE;
			for(int i=0; i<n; i++) {
				int sum = 0;
				for(int j=0; j<n; j++) {
					sum += map[i][j];
				}
				min = Math.min(min, sum);
			}
			sb.append(min).append("\n");
			
		}
		System.out.println(sb);
	}
}
