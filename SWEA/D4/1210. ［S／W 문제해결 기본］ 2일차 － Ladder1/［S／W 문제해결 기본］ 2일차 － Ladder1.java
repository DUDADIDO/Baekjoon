import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int[][] ladder = new int[100][100];
		for(int tc=1; tc<=10; tc++) {
			br.readLine();
			sb.append("#").append(tc).append(" ");
			for(int i=0; i<100; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<100; j++) {
					ladder[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			int startY = 99;
			int startX = 0;

			for(int i=0; i<100; i++) {
				if(ladder[99][i] == 2) 
					startX = i;
			}
			int curX = startX;
			int curY = startY;

			while (curY>0) {
			    if (curX-1 >= 0 && ladder[curY][curX-1] == 1) {
			        while (curX-1 >= 0 && ladder[curY][curX-1] == 1) {
			            curX--;
			        }
			        curY--;
			    } 
			    else if (curX+1 < 100 && ladder[curY][curX+1] == 1) {
			        while (curX+1 < 100 && ladder[curY][curX+1] == 1) {
			            curX++;
			        }
			        curY--;
			    } 
			    else {
			        curY--;
			    }
			}

			sb.append(curX).append("\n");


		}
		System.out.println(sb);
	}
}
