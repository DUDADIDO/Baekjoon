import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			String original = br.readLine();
			int cnt = 0;
			int length = original.length();
			int[] originArr = new int[length];
			int[] recoverArr = new int[length];
			
			for(int i=0; i<length; i++) {
				originArr[i] = Character.getNumericValue(original.charAt(i));
			}
			for(int i=0; i<length; i++) {
				if(recoverArr[i] != originArr[i]) {
					cnt++;
					for(int j=i; j<length; j++) {
						recoverArr[j] = originArr[i];
					}
				}
			}
			sb.append("#").append(tc).append(" ").append(cnt).append("\n");
		}
		System.out.println(sb);
	}
}
