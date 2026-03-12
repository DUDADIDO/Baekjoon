import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

	static int n, w, h, minBlock;
	
	static int[][] map = new int[15][12];
	static int[] result;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			minBlock = Integer.MAX_VALUE;
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			result = new int[n];
			for(int r=0; r<h; r++) {
				st = new StringTokenizer(br.readLine());
				for(int c=0; c<w; c++) {
					map[r][c] = Integer.parseInt(st.nextToken());
				}
			}
			dfs(0, map);
			sb.append(minBlock).append("\n");
		}
		System.out.println(sb);
	}

	static void dfs(int L, int[][] currentMap) {
		if(minBlock == 0) return;
		
		if (L == n) {

			/*
			 * 터질 블록 큐에 넣어두고 큐가 빌 때 까지 반복.
			 * 
			 * while(!q.isEmpty())
			 * 
			 * 블록 꺼냄. 본인 블록 위치 0 표시. 블록 좌표 및 폭발 범위 확인. 폭발 할 범위 좌표들 순환 좌표가 맵 범위 밖이면 다음 좌표로
			 * 아니라면 해당 좌표 값 확인 1이라면 0으로 바꾸고 1보다 크다면 큐에 넣기(좌표, 폭발범위)
			 * 
			 * 
			 * 나와서 중력 영향으로 아래로 밀기
			 */

			int cnt = 0;
			for(int r=0; r<h; r++) {
				for(int c=0; c<w; c++) {
					if(currentMap[r][c] > 0)cnt++;
				}
			}
			minBlock = Math.min(cnt, minBlock);
			return;
		}

		for (int i = 0; i < w; i++) {
			if(minBlock == 0) return;
			int[][] nextMap = copyMap(currentMap);
			
			solve(i, nextMap);
			dfs(L + 1, nextMap);
		}

	}

	static int[][] copyMap(int[][] currentMap) {
		int[][] tmp = new int[15][12];
		for (int i = 0; i < 15; i++) {
			tmp[i] = currentMap[i].clone();
		}
		return tmp;
	}

	static void solve(int col, int[][] tmpMap) {
		int startR = -1;
		for(int j=0; j<h; j++) {
			if (tmpMap[j][col] > 0) {
				startR = j;
				break;
			}
		}
		if(startR == -1) return;
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {startR, col, tmpMap[startR][col]});
		tmpMap[startR][col] = 0;
//		for(int i=0; i<n; i++) {
//			int bombCol = result[i];
//			for(int j=0; j<h; j++) {
//				if (tmpMap[j][bombCol] == 1) { // 폭발 크기가 1이면 자기만 터지고 끝
//					tmpMap[j][bombCol] = 0;
//					break;
//				}
//				else if(tmpMap[j][bombCol] > 1) {
//					q.offer(new int[] {j, bombCol, tmpMap[j][bombCol]});
//					tmpMap[j][bombCol] = 0;
//					break;
//				}
//			}
			while(!q.isEmpty()) {
				// 연쇄 폭발 처리
				int[] cur = q.poll();
				int r = cur[0];
				int c = cur[1];
				int bombSize = cur[2];
				for(int d=0; d<4; d++) {
					for(int bomb = 1; bomb<bombSize; bomb++) {
						int nr = r + dr[d]*bomb;
						int nc = c + dc[d]*bomb;
						
						if(nr<0 || nr>=h || nc<0 || nc>=w) break;
						if(tmpMap[nr][nc] == 1) tmpMap[nr][nc] = 0;
						else if(tmpMap[nr][nc] > 1) {
							q.offer(new int[] {nr, nc, tmpMap[nr][nc]});
							tmpMap[nr][nc] = 0;							
						}
					}
				}
			}
		
			//중력 밀기
			for(int c=0; c<w; c++) {
				int cursor = h-1;
				for(int r=h-1; r>=0; r--) {
					if(tmpMap[r][c] > 0) {
						int tmp = tmpMap[r][c];
						tmpMap[r][c] = 0;
						tmpMap[cursor][c] = tmp;
						cursor--;
					}
				}
			}
			

		}
}
