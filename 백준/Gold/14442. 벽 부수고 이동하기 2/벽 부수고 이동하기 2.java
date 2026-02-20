import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[][] map;
	static int[][][] visited;
	static int n, m, k;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		visited = new int[k+1][n][m];
		
		for(int i=0; i<n; i++) {
			String tmp = br.readLine();
			for(int j=0; j<m; j++) {
				map[i][j] = Character.getNumericValue(tmp.charAt(j));
			}
		}
		bfs(0, 0);
		int min = Integer.MAX_VALUE;
		for(int i=0; i<=k; i++) {
			if(visited[i][n-1][m-1] == 0)
				continue;
			min = Math.min(visited[i][n-1][m-1], min);
		}
		if(min == Integer.MAX_VALUE)
			min = -1;
		System.out.println(min);
	}
	static void bfs(int r, int c) {
		Queue<int[]> q = new LinkedList<>();
		visited[0][r][c] = 1;
		q.offer(new int[] {r, c, 0});
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			int cr = cur[0];
			int cc = cur[1];
			int broken = cur[2];
			for(int i=0; i<4; i++) {
				int nr = cr + dr[i];
				int nc = cc + dc[i];
				
				if(nr < 0 || nr >= n || nc < 0 || nc >= m) continue;
				if(map[nr][nc] == 0) {
					if(visited[broken][nr][nc] == 0) {
						visited[broken][nr][nc] = visited[broken][cr][cc]+1;
						q.offer(new int[] {nr, nc, broken});
					}
				}
				else if(map[nr][nc] == 1) {
					
					if(broken < k && visited[broken+1][nr][nc] == 0) {
						visited[broken+1][nr][nc] = visited[broken][cr][cc] + 1;
						q.offer(new int[] {nr, nc, broken+1});
					}
				}
			}
		}
		
	}
}
