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

			combi(0, 0);
			sb.append(min).append("\n");
		}
		System.out.println(sb);
	}
	static void combi(int L, int start) {
		if(L == N/2) {
			calc();
			return;
		}
		
		for(int i=start; i<N; i++) {
			selected[i] = true;
			combi(L+1, i+1);
			selected[i] = false;
		}
		
	}
	static void calc() {
		List<Integer> food1 = new ArrayList<>();
		List<Integer> food2 = new ArrayList<>();
		for(int i=0; i<N; i++) {
			if(selected[i])
				food1.add(i);
			else
				food2.add(i);
		}
		int food1Sum = 0;
		int food2Sum = 0;
		for(int i=0; i<N/2; i++) {
			for(int j=0; j<N/2; j++) {
				if(i == j) {
					continue;
				}
				food1Sum += map[food1.get(i)][food1.get(j)];
				food2Sum += map[food2.get(i)][food2.get(j)];
			}
		}
		int gap = Math.abs(food1Sum - food2Sum);
		min = Math.min(gap, min);
	}
}
