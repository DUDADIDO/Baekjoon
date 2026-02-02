import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for(int tc=1; tc<=10; tc++) {
			StringTokenizer st;
			List<Integer> list = new ArrayList<>();
			sb.append("#").append(tc).append(" ");
			
			int length = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<length; i++) {
				list.add(Integer.parseInt(st.nextToken()));
			}
			int commandLength = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<commandLength; i++) {
				char command = st.nextToken().charAt(0);
				if(command == 'I') {
					int x = Integer.parseInt(st.nextToken());
					int y = Integer.parseInt(st.nextToken());
					for(int j=0; j<y; j++) {
						list.add((x+j), Integer.parseInt(st.nextToken()));
					}
				}
				else {
					int x = Integer.parseInt(st.nextToken());
					int y = Integer.parseInt(st.nextToken());
					for(int j=0; j<y; j++) {
						list.remove(x);
					}
				}
				
			}
			
			for(int i=0; i<10; i++) {
				sb.append(list.get(i)).append(" ");
			}
			
			sb.append("\n");
		}
		System.out.println(sb);
		
	}
}
