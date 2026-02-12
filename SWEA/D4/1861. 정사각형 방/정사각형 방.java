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
			int maxStraight = Integer.MIN_VALUE;
			int maxRoomNum = 0;
			int currentStart = list.get(0).roomNum;
			int currentStraight = 1;
			for(int i=0; i<list.size()-1; i++) {
				Room cur = list.get(i);
				Room next = list.get(i+1);
				int dist = Math.abs(cur.r - next.r) + Math.abs(cur.c - next.c); 
				if(cur.roomNum+1 == next.roomNum && dist == 1) {
					currentStraight++;
				}
				else {
					currentStraight = 1;
					currentStart = next.roomNum;
				}
				
				if(currentStraight > maxStraight) {
					maxRoomNum = currentStart;
					maxStraight = currentStraight 	;
				}
				
			}
			sb.append(maxRoomNum).append(" ").append(maxStraight).append("\n");
		}
		System.out.println(sb);
	}
}
