import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Solution {

	static int N = 4001;
	static int[][] map = new int[N][N];
	static int[] dc = {0, 0, -1, 1};
	static int[] dr = {1, -1, 0, 0}; 
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			sb.append("#").append(tc).append(" ");
			
			int totalEnergy = 0; // 원자의 보유 에너지 1~100
			int count = Integer.parseInt(br.readLine()); // 원자 개수
			
			ArrayDeque<atom> dq = new ArrayDeque<>(); // 살아있는 원자 리스트
			
			for(int i=0; i<count; i++) {
				st = new StringTokenizer(br.readLine());
				int c = (Integer.parseInt(st.nextToken())+1000)<<1;
				int r = (Integer.parseInt(st.nextToken())+1000)<<1;
				int dir = Integer.parseInt(st.nextToken());
				int e = Integer.parseInt(st.nextToken());
				
				map[r][c] = e;
				dq.addLast(new atom(c, r, dir, e));
				
			}
			
			while(!dq.isEmpty()) {
				atom cur = dq.pollFirst();
				
				// 1. 충돌 확인
				if(map[cur.r][cur.c] != cur.e) {
					totalEnergy += map[cur.r][cur.c];
					map[cur.r][cur.c] = 0;
					continue;
				}
				
				// 2. 충돌되지 않았다면 다음 방향에 기록  후 덱에 넣기
				map[cur.r][cur.c] = 0; // 경계에 충돌해도 그냥 지움
				int nr = cur.r + dr[cur.dir];
				int nc = cur.c + dc[cur.dir];
				
				if(nr<0 || nr>4000 || nc<0 || nc>4000)
					continue;
				
				cur.r = nr;
				cur.c = nc;
				map[cur.r][cur.c] += cur.e;
				dq.addLast(cur);
				
			}
			
			sb.append(totalEnergy).append("\n");
		}
		System.out.println(sb);
		
	}
	
	static class atom {
		int r, c, dir, e;

		public atom(int c, int r, int dir, int e) {
			super();
			this.c = c;
			this.r = r;
			this.dir = dir;
			this.e = e;
		}
	
	
		
	}
}
