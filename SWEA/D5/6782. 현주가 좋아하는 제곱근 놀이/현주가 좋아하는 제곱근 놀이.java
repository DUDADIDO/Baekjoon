import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			sb.append("#").append(tc).append(" ");
			long n = Long.parseLong(br.readLine());
			int cnt = 0;
			while(n != 2) {
				long sqrt = (long)Math.sqrt(n);
				if(sqrt*sqrt == n) {
					n = (int)Math.sqrt(n);
					cnt++;
				}
				else {
					long nextNum = (sqrt+1) * (sqrt+1);
//					System.out.println("nextNum : " + nextNum + " n : " + n);
					cnt = cnt + (int)(nextNum - n);
					n = nextNum;
				}
			}
			sb.append(cnt).append("\n");
		}
		System.out.println(sb);
	}
}
