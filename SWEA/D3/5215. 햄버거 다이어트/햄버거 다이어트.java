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
			
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				scores[i] = Integer.parseInt(st.nextToken());
				kcal[i] = Integer.parseInt(st.nextToken());
			}
			maxScore = 0;
			dfs(0, 0, 0);
			sb.append(maxScore).append("\n");
			
		}
		System.out.println(sb);

	}
	static void dfs(int idx, int scoreSum, int kcalSum) {
		if(kcalSum > L)
			return;
		if(idx == N) {
			maxScore = Math.max(scoreSum, maxScore);
			return;
		}
		
		dfs(idx+1, scoreSum+scores[idx], kcalSum+kcal[idx]); // 고름
		dfs(idx+1, scoreSum, kcalSum); // 고르지 않음
		
	}
}
