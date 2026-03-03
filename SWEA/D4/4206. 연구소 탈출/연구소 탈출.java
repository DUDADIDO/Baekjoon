import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;




public class Solution {
	static int[][] map;
	static int N, M, startR, startC;
	static boolean[][] visited;
	
	static Queue<int[]> personQ;
	static Queue<int[]> gasQ;
	
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		
		
		for(int tc=1; tc<=T; tc++) {
			sb.append("#").append(tc).append(" ");
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			map = new int[N][M];
			visited = new boolean[N][M];
			
			personQ = new LinkedList<>();
			gasQ = new LinkedList<>();
			
			for(int r=0; r<N; r++) {
				st = new StringTokenizer(br.readLine());
				for(int c=0; c<M; c++) {
					map[r][c] = Integer.parseInt(st.nextToken());
					if(map[r][c] == 2) {
						gasQ.offer(new int[] {r, c});
					}
					else if(map[r][c] == 3) {
						personQ.offer(new int[] {r, c});
						visited[r][c] = true;
						startR = r;
						startC = c;
					}
				}
			}
			int result = solve();
			
			if(result == -1) {
				sb.append("ZOMBIE").append("\n");
			}
			else if(result == -2) {
				sb.append("CANNOT ESCAPE").append("\n");
			}
			else {
				sb.append(result).append("\n");
			}
		}
		System.out.println(sb);
	}
	
	static int solve() {
		if(isolated() == false) return -2;
		
		int time = 0;
		while(!personQ.isEmpty()) {
			int pSize = personQ.size();
			for(int i=0; i<pSize; i++) {
				int[] cur = personQ.poll();
				
				int cr = cur[0];
				int cc = cur[1];
				if(map[cr][cc] == 2) continue;
				if(cr==0 || cr==N-1 || cc==0 || cc==M-1) return time+1;
				for(int d=0; d<4; d++) {
					int nr = cr + dr[d];
					int nc = cc + dc[d];
					
					if(nr<0 || nr>=N || nc<0 || nc>=M) continue;
					if(map[nr][nc] == 1 || map[nr][nc] == 2 || visited[nr][nc]) continue;
					visited[nr][nc] = true;
					personQ.offer(new int[] {nr, nc});
				}
			}
			int gSize = gasQ.size();
			for(int i=0; i<gSize; i++) {
				int[] cur = gasQ.poll();
				int cr = cur[0];
				int cc = cur[1];
				for(int d=0; d<4; d++) {
					int nr = cr + dr[d];
					int nc = cc + dc[d];
					
					if(nr<0 || nr>=N || nc<0 || nc>=M) continue;
					if(map[nr][nc] == 1) continue;
					
					map[nr][nc] = 2;
					gasQ.offer(new int[] {nr, nc});
				}
			}
			
			
			time++;
		}
		return -1;
	}
	
	static boolean isolated() {
		Queue<int[]> q = new LinkedList<>();
		boolean[][] visited = new boolean[N][M];
		
		visited[startR][startC] = true;
		q.offer(new int[] {startR, startC});
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			
			int cr = cur[0];
			int cc = cur[1];
			
			if(cr==0 || cr==N-1 || cc==0 || cc==M-1) return true; // 모서리 부분에 있다면 탈출 가능하므로 true
			
			for(int d=0; d<4; d++) {
				int nr = cr + dr[d];
				int nc = cc + dc[d];
				
				if(nr<0 || nr>=N || nc<0 || nc>=M) continue;
				if(map[nr][nc]==1 || visited[nr][nc]) continue;
				
				visited[nr][nc] = true;
				q.offer(new int[] {nr, nc});
			}
		}
		return false;
		
	}

}
