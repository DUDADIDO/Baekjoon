import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
	static class Coord {
		int r, c;

		public Coord(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			List<Coord> list = new ArrayList<>();
			sb.append("#").append(tc).append(" ");
			
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int maxCnt = Integer.MIN_VALUE;
			for(int i=0; i<n; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<n; j++) {
					int num = Integer.parseInt(st.nextToken());
					if(num == 1) {
						list.add(new Coord(i, j));
					}
				}
			}
			int homeCnt = list.size();
			int[][][] calc = new int[n][n][homeCnt];
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					for(int k=0; k<homeCnt; k++) {
						calc[i][j][k] = getDist(i, j, list.get(k).r, list.get(k).c);
					}
					Arrays.sort(calc[i][j]);
				}
			}
			
			for(int k=1; k<=n+2; k++) {
				for(int r=0; r<n; r++) {
					for(int c=0; c<n; c++) {
						int distance = k-1;
						int cost = (k*k) + ((k-1) * (k-1));
						int cnt = 0;
						for(int idx=0; idx<homeCnt; idx++) {
							if(calc[r][c][idx] > distance) break;
							else cnt++;
						}
						int result = (cnt * m) - cost;
						if(result >= 0) {
							maxCnt = Math.max(maxCnt, cnt);
						}
					}
				}
			}
			sb.append(maxCnt).append("\n");
		}
		System.out.println(sb);	
	}
	static int getDist(int r1, int c1, int r2, int c2) {
		return Math.abs(r1-r2) + Math.abs(c1-c2);
	}
}
