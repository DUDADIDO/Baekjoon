import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[][] node;
	static int[][] graph;
	static boolean[][] possible;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		for(int tc=1; tc<=T; tc++) {
//			sb.append("#").append(tc).append(" ");
			int n = Integer.parseInt(br.readLine());
			

			node = new int[n+2][2];
			possible = new boolean[n+2][n+2];

			
			for(int i=0; i<n+2; i++) {
				st = new StringTokenizer(br.readLine());
				node[i][0] = Integer.parseInt(st.nextToken());
				node[i][1] = Integer.parseInt(st.nextToken());
			}
			
			graph = new int[n+2][n+2];
			for(int i=0; i<n+2; i++) {
				for(int j=0; j<n+2; j++) {
					if(i==j) graph[i][j] = 0;
					else {
						if(getDistance(node[i][0], node[i][1], node[j][0], node[j][1]) <= 1000) {
							possible[i][j] = true;
						}
					}
				}
			}
			for(int k=0; k<n+2; k++) {
				for(int i=0; i<n+2; i++) {
					for(int j=0; j<n+2; j++) {
						if(possible[i][k] && possible[k][j])
							possible[i][j] = true;
					}
				}
			}
			sb.append(possible[0][n + 1] ? "happy\n" : "sad\n");
		}
		System.out.println(sb);
	}
	static int getDistance(int r1, int c1, int r2, int c2) {
		return Math.abs(r1-r2) + Math.abs(c1-c2);
	}
}
