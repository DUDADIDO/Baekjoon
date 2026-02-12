import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {

	static class Room {
		int roomNum;
		int r;
		int c;
		public Room(int roomNum, int r, int c) {
			this.roomNum = roomNum;
			this.r = r;
			this.c = c;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			sb.append("#").append(tc).append(" ");
			int n = Integer.parseInt(br.readLine());
			List<Room> list = new ArrayList<>();
			
			for(int i=0; i<n; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<n; j++) {
					int roomNum = Integer.parseInt(st.nextToken());
					int r = i;
					int c = j;
					list.add(new Room(roomNum, r, c));
				}
			}
			list.sort((o1, o2) -> {
				return o1.roomNum - o2.roomNum;
			}); 
			int maxCnt = Integer.MIN_VALUE;
			int maxRoom = 0;
			int start = 0;
			int end = start + 1;
			int cur = 0;
			int straight = 1;
			for(int i=0; i<list.size(); i++) {
				if(end == n*n)
					break;
				int curR = list.get(cur).r;
				int curC = list.get(cur).c;
				int curNum = list.get(cur).roomNum;
				int nextR = list.get(end).r;
				int nextC = list.get(end).c;
				int nextNum = list.get(end).roomNum;
				if(curNum+1 == nextNum) {
					int distance = Math.abs(curR - nextR) + Math.abs(curC - nextC);
					if(distance == 1) {
						end++;
						cur++;
						straight++;
						if(straight > maxCnt) {
							maxCnt = straight;
							maxRoom = start;
						}
					}
					else {
						cur = start = end;
						end = start+1;
						straight = 1;
					}
				}
				else {
					cur = start = end;
					end = start+1;
					straight = 1;
				}
			}
			if(straight > maxCnt) {
				maxCnt = straight;
				maxRoom = start;
			}
			sb.append(maxRoom+1).append(" ").append(maxCnt).append("\n");
		}
		System.out.println(sb);
	}
}
