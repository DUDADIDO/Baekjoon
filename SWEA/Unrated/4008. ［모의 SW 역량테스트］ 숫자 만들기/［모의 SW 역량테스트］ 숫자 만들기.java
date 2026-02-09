import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int[] nums, opCnt;
	static char[] op, chosenOp;
	static int N, sum, min, max, minGap;
	static boolean[] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		for(int tc=1; tc<=T; tc++) {
			sb.append("#").append(tc).append(" ");
			N = Integer.parseInt(br.readLine());
			nums = new int[N];
			opCnt = new int[4];
			visited = new boolean[N-1];
			sum = 0;
			min = Integer.MAX_VALUE;
			max = Integer.MIN_VALUE;
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<4; i++) {
				opCnt[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++) {
				nums[i] = Integer.parseInt(st.nextToken());
			}
			
			dfs(0, nums[0]);
			sb.append(max - min).append("\n");
		}
		System.out.println(sb);
	}

	static void dfs(int L, int sum) {
		if(L == N-1) {
			max = Math.max(sum,  max);
			min = Math.min(sum,  min);
			return;
		}
		for(int i=0; i<4; i++) {
			if(opCnt[i] > 0) {
				int nextSum = sum;
				if(i == 0) nextSum += nums[L+1];
				else if(i == 1) nextSum -= nums[L+1];
				else if(i == 2) nextSum *= nums[L+1];
				else nextSum /= nums[L+1];
				opCnt[i]--;
				dfs(L+1, nextSum);
				opCnt[i]++;
			}
		}


	}
}
