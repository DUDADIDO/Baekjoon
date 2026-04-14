import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int[][] globalMap;
	static int d, w, k;
	static int min;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			sb.append("#").append(tc).append(" ");
			st = new StringTokenizer(br.readLine());
			d = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			
			min = Integer.MAX_VALUE;
			globalMap = new int[d][w];
			
			for(int i=0; i<d; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<w; j++) {
					globalMap[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			dfs(0, 0);
			sb.append(min).append("\n");
		}
		System.out.println(sb);	
	}
	
	static void dfs(int row, int count) {
		if(count >= min) return;
		
		if(row == d) {
			boolean flag = true;
			for(int i=0; i<w; i++) {
				if(!check(i)) { // 조건을 충족하는지 검사
					flag = false; // 하나라도 조건을 충족하지 못하면 false
					break;
				}
			}
			if(flag) {
				min = Math.min(min, count);
				
			}
			return;
		}
		dfs(row+1, count); // 아무것도 투약하지 않음
		
		int[] tmpMap = new int[w];
		for(int i=0; i<w; i++) 
			tmpMap[i] = globalMap[row][i];
		for(int i=0; i<w; i++) globalMap[row][i] = 0; // 0 투약
		dfs(row+1, count+1);
		
		for(int i=0; i<w; i++) globalMap[row][i] = 1; // 1 투약
		dfs(row+1, count+1);
		
		for(int i=0; i<w; i++) globalMap[row][i] = tmpMap[i]; // 복구
	}
	
	static boolean check(int a) {
		if(k == 1) return true;
		int counter = 1;
		for(int i=1; i<d; i++) {
			if(globalMap[i][a] == globalMap[i-1][a]) counter++;
			else counter = 1;
			if(counter >= k) return true;
		}
		return false;
	}
	
	
}
