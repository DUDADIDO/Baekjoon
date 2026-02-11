import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static int n;
	static char[][] map;
	static boolean[][] visited;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	public class coor {
		public int x, y;
		public coor(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int blindCnt = 0;
		int cnt = 0;
		n = Integer.parseInt(br.readLine());
		map = new char[n][n];
		visited = new boolean[n][n];
		for(int i=0; i<n; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(!visited[i][j]) {
					bfs(i, j, map[i][j]);
					cnt++;
				}
			}
		}
		visited = new boolean[n][n];
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(!visited[i][j]) {
					bfsBlind(i, j, map[i][j]);
					blindCnt++;
				}
				
			}
		}
		System.out.println(cnt + " " + blindCnt);
		
	}
	static void bfs(int r, int c, char color) {
		visited[r][c] = true;
		
		Queue<int[]> q = new ArrayDeque<>();
		q.add(new int[] {r, c});
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			int curR = cur[0];
			int curC = cur[1];
			for(int i=0; i<4; i++) {
				int nextR = curR + dr[i];
				int nextC = curC + dc[i];
				if(nextR<0 || nextR>=n || nextC<0 || nextC>=n)
					continue;
				if(map[nextR][nextC] == color && !visited[nextR][nextC]) {
					q.add(new int[] {nextR, nextC});
					visited[nextR][nextC] = true;
				}
			}
			

		}
	}
	
	static void bfsBlind(int r, int c, char color) {
		visited[r][c] = true;
		
		Queue<int[]> q = new ArrayDeque<>();
		q.add(new int[] {r, c});
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			int curR = cur[0];
			int curC = cur[1];
			for(int i=0; i<4; i++) {
				int nextR = curR + dr[i];
				int nextC = curC + dc[i];
				if(nextR<0 || nextR>=n || nextC<0 || nextC>=n)
					continue;
				if(color == 'R' || color == 'G') {
					if((map[nextR][nextC] == 'R' || map[nextR][nextC] == 'G') && !visited[nextR][nextC]) {
						q.add(new int[] {nextR, nextC});
						visited[nextR][nextC] = true;
					}	
				}
				else {
					if(map[nextR][nextC] == color) {
						if(map[nextR][nextC] == color && !visited[nextR][nextC]) {
							q.add(new int[] {nextR, nextC});
							visited[nextR][nextC] = true;
						}	
					}
				}
				
			}
		}
	}
}
