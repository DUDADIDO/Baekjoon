import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Solution {
	static int[][] map = new int[4][4];
	static HashSet<String> set = new HashSet<>();
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			
			set.clear();
			for(int i=0; i<4; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<4; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			for(int i=0; i<4; i++) {
				for(int j=0; j<4; j++) {
					dfs(i, j, 0, "");
				}
			}
			sb.append(set.size()).append("\n");
			
		}
		System.out.println(sb);
	}
	static void dfs(int r, int c, int L, String str) {
		if(L == 7) {
			set.add(str);
			return;
		}
		for(int d=0; d<4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			
			if(nr<0 || nr>=4 || nc<0 || nc>=4) continue;
			
			dfs(nr, nc, L+1, str + map[nr][nc]);
		}
	}

}
