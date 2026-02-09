import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] opCnt, nums;
	static int n, min, max;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		min = Integer.MAX_VALUE;
		max = Integer.MIN_VALUE;
		n = Integer.parseInt(br.readLine());
		opCnt = new int[4];
		nums = new int[n];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<4; i++) {
			opCnt[i] = Integer.parseInt(st.nextToken());
		}
		dfs(0, nums[0]);
		sb.append(max).append("\n").append(min);
		System.out.println(sb);
		
	}
	static void dfs(int L, int sum) {
		if(L == n-1) {
			max = Math.max(sum, max);
			min = Math.min(sum, min);
			
		
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
