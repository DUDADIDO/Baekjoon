import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	static int n, cnt;
	static boolean[] col, slash, bSlash;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			sb.append("#").append(tc).append(" ");
			n = Integer.parseInt(br.readLine());
			
			cnt = 0;
			col = new boolean[n+1];
			slash = new boolean[2*n+1];
			bSlash = new boolean[2*n];
			
			setQueen(1);
			sb.append(cnt).append("\n");
		}
		System.out.println(sb);


		
	}
	
	static void setQueen(int row) {
		if(row == n+1) {
			++cnt;
			return;
		}
		
		for(int c=1; c<=n; c++) {
			// 유망성 체크 : row행 c열에 두는것이 가능한지
			if(col[c] || slash[row+c] || bSlash[(row-c)+n]) // 같은 열에 있거나, 대각에 퀸이 존재하면 그냥 넘김. 
				continue;
			col[c] = slash[row+c] = bSlash[(row-c)+n] = true;
			setQueen(row+1);
			col[c] = slash[row+c] = bSlash[(row-c)+n] = false;;
			
			
		}
	}
	
}
