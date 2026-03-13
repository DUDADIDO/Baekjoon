import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution {
	static int[][] map;
	static int[][] minDist;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static int n;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			
			n = Integer.parseInt(br.readLine());
			map = new int[n][n];
			minDist = new int[n][n];
			
			
			for(int i=0; i<n; i++) {
				String input = br.readLine();
				for(int j=0; j<n; j++) {
					map[i][j] = input.charAt(j) - '0';
				}
				Arrays.fill(minDist[i], 100000000);
			}
			
			dijkstra(0, 0);
			sb.append(minDist[n-1][n-1]).append("\n");
			
		}
		System.out.println(sb);
	}
	
	static void dijkstra(int r, int c) {
		minDist[r][c] = 0;
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1[2], o2[2]));
		pq.offer(new int[] {r, c, 0});
		
		while(!pq.isEmpty()) {
			int[] cur = pq.poll();
			int cr = cur[0];
			int cc = cur[1];
			int cw = cur[2];
			
			if(cw > minDist[cr][cc]) continue;
			
			for(int d=0; d<4; d++) {
				int nr = cr + dr[d];
				int nc = cc + dc[d];
				
				if(nr<0 || nr>=n || nc<0 || nc>=n) continue;
				
				int nextDist = minDist[cr][cc] + map[nr][nc];
				if(nextDist < minDist[nr][nc]) {
					minDist[nr][nc] = nextDist;
					pq.offer(new int[] {nr, nc, nextDist});
				}
			}
			
		}
	}

}
