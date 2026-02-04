import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] nums, visit, ans;
	static int N, M;
	static StringBuilder sb = new StringBuilder();
	static void dfs(int L, int S) { // L은 레벨, S는 시작지점
		if(L == M) { // 숫자 N개중 M개를 뽑았다면
			for(int num : ans)
				sb.append(num).append(" ");
			sb.append("\n");
		}
		else { // 아직 숫자를 더 뽑아야 한다면
			for(int i=0; i<N; i++) {
				if(visit[i] == 0) {
					visit[i] = 1;
					ans[L] = nums[i];
					dfs(L+1, S+1);
					visit[i] = 0;
				}
				
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		nums = new int[N];
		visit = new int[N];
		ans = new int[M];
		
		for(int i=0; i<N; i++) {
			nums[i] = i+1;
		}
		
		dfs(0, 0);
		System.out.println(sb);
		
		
		
		
	}
}
