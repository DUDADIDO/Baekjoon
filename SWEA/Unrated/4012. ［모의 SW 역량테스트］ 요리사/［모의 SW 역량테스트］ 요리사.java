import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
	static int N, min;
	static int[][] map;
	static boolean[] selected;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			sb.append("#").append(tc).append(" ");
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			min = Integer.MAX_VALUE;
			selected = new boolean[N];
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			combi(1, 1, 1 << 0);
			sb.append(min).append("\n");
		}
		System.out.println(sb);
	}
	static void combi(int L, int start, int mask) {
		if(L == N/2) {
			calc(mask);
			return;
		}
		
		for(int i=start; i<N; i++) {
			combi(L+1, i+1, mask | (1 << i));
		}
		
	}
	static void calc(int mask) {
		int food1Sum = 0;
		int food2Sum = 0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if((mask & (1 << i)) != 0 && ((mask & (1 << j)) != 0)) {
					food1Sum += map[i][j];
				}
				else if((mask & (1 << i)) == 0 && ((mask & (1 << j)) == 0)) {
					food2Sum += map[i][j];
				}
			}
		}
		int gap = Math.abs(food1Sum - food2Sum);
		min = Math.min(gap, min);
	}
}
