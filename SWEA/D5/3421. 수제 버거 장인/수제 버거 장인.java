import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int N, M, totalCnt, foods[][];
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			sb.append("#").append(tc).append(" ");
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			foods = new int[M][2];
			visited = new boolean[N];
			totalCnt = 0;
			
			for(int i=0; i<M; i++) {
				st = new StringTokenizer(br.readLine());
				foods[i][0] = Integer.parseInt(st.nextToken())-1;
				foods[i][1] = Integer.parseInt(st.nextToken())-1;
			}
			
			dfs(0, 0);
			sb.append(totalCnt).append("\n");
		}
		System.out.println(sb);
	}
	static void dfs(int idx, int flag) {
		// 비트마스킹
		for(int i=0; i<M; i++) {
			//비트마스킹 조건에 걸리면 가지치기
			int check1 = foods[i][0];
			int check2 = foods[i][1];
			if((flag & (1 << check1)) != 0 && (flag & (1 << check2)) != 0) {
				return;
			}
		}

		if(idx == N) { // 리프노드면
			totalCnt++;
			return;
		}
		

		dfs(idx+1, flag | 1 << (idx));
		
		dfs(idx+1, flag);
	}
}
