import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	static class Cell {
		int r, c, size, dir;

		public Cell(int r, int c, int size, int dir) {
			super();
			this.r = r;
			this.c = c;
			this.size = size;
			this.dir = dir;
		}
		
	}
	static Queue<Cell> q;
	static int[][] map;
	static int[] dr = {0, -1, 1, 0, 0}; // 상 하 좌 우
	static int[] dc = {0, 0, 0, -1, 1};
	static int n;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
		
			q = new LinkedList<>();
			st = new StringTokenizer(br.readLine());
			
			n = Integer.parseInt(st.nextToken()); // 셀의 개수 (맵 크기)
			int m = Integer.parseInt(st.nextToken()); // 격리 시간
			int k = Integer.parseInt(st.nextToken()); // 미생물 군집의 수
			
			map = new int[n][n];
			for(int i=0; i<k; i++) {
				st = new StringTokenizer(br.readLine());
				int r = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				int size = Integer.parseInt(st.nextToken());
				int dir = Integer.parseInt(st.nextToken());
				q.offer(new Cell(r, c, size, dir));
			}
			
			for(int i=0; i<m; i++) {
				move();
			}
			int result = 0;
			for(Cell cell : q) {
				result += cell.size;
			}
			sb.append(result).append("\n");
			
		}
		System.out.println(sb);
	}
	
	static void move() {
		Cell[][] map = new Cell[n][n]; // 해당 셀에 군집이 있는지 확인하기 위한 배열
		int[][] maxMap = new int[n][n]; // 해당 셀에 군집이 있다면, 최대 군집의 사이즈를 체크하기 위한 배열
		int size = q.size();
		for(int i=0; i<size; i++) { // 한 시간에 모든 군집 한번씩만 이동
			Cell cur = q.poll();
			int nr = cur.r + dr[cur.dir];
			int nc = cur.c + dc[cur.dir];
			
			if(nr==0 || nr==n-1 || nc==0 || nc==n-1) { // 만약 약품을 바른 곳에 도달했다면
				cur.size /= 2; // 사이즈를 줄인다.
				cur.dir = changeDir(cur.dir); // 방향을 바꿔준다.
			}
			
			if(cur.size == 0) continue; // 소멸
			
			if(map[nr][nc] == null) { // 해당 셀에 아직 어떠한 군집도 없다면
				map[nr][nc] = new Cell(nr, nc, cur.size, cur.dir); // 해당 셀에 군집을 표시
				maxMap[nr][nc] = cur.size; // 해당 셀의 최대 사이즈도 표시
			}
			else { // 만약 다른 군집이 존재한다면(충돌이 일어난다면)
				map[nr][nc].size += cur.size; // 우선 군집의 사이즈는 더해준다.
				if(cur.size > maxMap[nr][nc]) { // 새로 들어온 군집이 기존의 군집의 크기보다 더 크다면 방향을 바꿔준다.
					maxMap[nr][nc] = cur.size; // 해당 셀의 군집의 최대 사이즈 갱신
					map[nr][nc].dir = cur.dir; // 해당 셀의 군집의 이동방향 갱신
				}
			}
		}
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(map[i][j] != null) q.offer(map[i][j]); // 최종적으로 살아남은 군집들만 다시 큐에 넣어준다.
			}
		}
	}
	static int changeDir(int dir) { // 군집의 이동방향을 바꿔주는 함수
		if(dir == 1) return 2; // 상 -> 하
		else if(dir == 2) return 1; // 하 -> 상
		else if(dir == 3) return 4; // 좌 -> 우
		else return 3; // 우 -> 좌
	}
	

}
