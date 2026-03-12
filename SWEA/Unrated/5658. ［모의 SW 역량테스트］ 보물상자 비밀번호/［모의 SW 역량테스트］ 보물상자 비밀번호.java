import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Solution {
	static int front, rear, unit;
	static char[] pass = new char[28*2];
	static TreeSet<Integer> set = new TreeSet<>(Collections.reverseOrder());
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
	
			set.clear();
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int index = Integer.parseInt(st.nextToken());
			front = 0;
			rear = n-1;
			unit = n/4;
			String input = br.readLine();
			for(int i=0; i<input.length(); i++) {
				pass[i+n] = pass[i] = input.charAt(i);
			}
			for(int rotation=0; rotation<unit; rotation++) {
				int offset = n - rotation;
				for(int j=0; j<4; j++) {
					int start = offset + (unit*j);
					String tmp = "";
					for(int k=start; k<start+unit; k++) {
						tmp += pass[k];
					}
					set.add(Integer.parseInt(tmp, 16));
				}
			}
			for(int i=0; i<index-1; i++) {
				set.pollFirst();
			}
			
			sb.append(set.pollFirst()).append("\n");
			
		}
		System.out.println(sb);
	}

}
