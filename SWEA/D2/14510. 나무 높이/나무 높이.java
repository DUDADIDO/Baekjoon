import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			sb.append("#").append(tc).append(" ");
			int odd = 0;
			int even = 0;
			int maxHeight = Integer.MIN_VALUE;
			int n = Integer.parseInt(br.readLine());
			int[] tree = new int[n];
			int[] gaps = new int[n];
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<n; i++) {
				tree[i] = Integer.parseInt(st.nextToken());
				maxHeight = Math.max(tree[i], maxHeight);
			}
			for(int i=0; i<n; i++) {
				int gap = maxHeight - tree[i];
				odd += gap % 2;
				even += gap / 2;
			}
			
			if(even > odd) {
				while(even - odd > 1) {
					even--;
					odd +=2 ;
				}
			}
			int result = 0;
			if(odd > even) {
				result = odd * 2 - 1;
			}
			else {
				result = even * 2;
			}
			sb.append(result).append("\n");
		}
		System.out.println(sb);
		
	}
}
