

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int N, L, maxScore;
	static int[] kcal, scores;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			sb.append("#").append(tc).append(" ");
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			kcal = new int[N];
			scores = new int[N];
			maxScore = 0;
			
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				scores[i] = Integer.parseInt(st.nextToken());
				kcal[i] = Integer.parseInt(st.nextToken());
			}
			
			dfs(0, 0, 0, 0);
			sb.append(maxScore).append("\n");
		}
		System.out.println(sb);
	}
	static void dfs(int idx, int start, int scoreSum, int kcalSum) {
		if(kcalSum > L)
			return;
		maxScore = Math.max(scoreSum, maxScore);
		for(int i=start; i<N; i++) {
			dfs(idx+1, i+1, scoreSum+scores[i], kcalSum+kcal[i]); // 고름
		}
		

		
	}
}
