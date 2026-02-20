import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	static int[][] map;
	static boolean[][] visited;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static int n;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			sb.append("#").append(tc).append(" ");
			int maxCnt = Integer.MIN_VALUE;
			n = Integer.parseInt(br.readLine());
			map = new int[n][n];
			int maxDay = Integer.MIN_VALUE;
			for(int i=0; i<n; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<n; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					maxDay = Math.max(maxDay, map[i][j]);
				}
			}
			for(int day=0; day<maxDay; day++) {
				int cnt = 0;
				visited = new boolean[n][n];
				for(int r=0; r<n; r++) {
					for(int c=0; c<n; c++) {
						if(!visited[r][c] && map[r][c] > day) {
							bfs(day, r, c);
							cnt++;
						}
					}
				}
				maxCnt = Math.max(cnt, maxCnt);
			}
			sb.append(maxCnt).append("\n");
			
		}
		System.out.println(sb);	
	}
	static void bfs(int day, int r, int c) {
		Queue<int[]> q = new LinkedList<>();
		visited[r][c] = true;
		q.offer(new int[] {r, c});
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			int cr = cur[0];
			int cc = cur[1];
			
			for(int i=0; i<4; i++) {
				int nr = cr + dr[i];
				int nc = cc + dc[i];
				
				if(nr < 0 || nr >= n || nc < 0 || nc >= n) continue;
				if(map[nr][nc] <= day || visited[nr][nc]) continue;
				
				visited[nr][nc] = true;
				q.offer(new int[] {nr, nc});
				
				
			}
		}
	}
	
}
