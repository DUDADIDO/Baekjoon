import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int M, N;
	static int[] nums, visit, ans;
	static StringBuilder sb = new StringBuilder();
	static void dfs(int L, int start) {
		if(L == M ) {
			for(int num : ans) {
				sb.append(num).append(" ");
			}
			sb.append("\n");
		}
		else {
//			for(int i=start; i<N; i++) {
//				if(visit[i] == 0) {
//					visit[i] = 1;
//					ans[L] = nums[i];
//					dfs(L+1, i+1);
//					visit[i] = 0;
//				}
//			}
			
			for(int i=start; i<N; i++) {
				ans[L] = nums[i];
				dfs(L+1, i+1);
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br=  new BufferedReader(new InputStreamReader(System.in));
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
