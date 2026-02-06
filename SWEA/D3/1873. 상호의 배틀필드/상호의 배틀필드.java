import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static char[][] map;
	static String command;
	static int r, c, W, H;
	static char tank;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			sb.append("#").append(tc).append(" ");
			st = new StringTokenizer(br.readLine());
			H = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			map = new char[H][W];
			for(int i=0; i<H; i++) {
				map[i] = br.readLine().toCharArray();
			}
			for(int i=0; i<H; i++) {
				for(int j=0; j<W; j++) {
					if(map[i][j] == '<' || map[i][j] == '>' || map[i][j] == '^' || map[i][j] == 'v') {
						r = i;
						c = j;
						tank = map[i][j];
					}
				}
			}
			br.readLine();
			command = br.readLine();
			
			for(int i=0; i<command.length(); i++) {
				char curCommand = command.charAt(i);
				
				if(curCommand == 'U')
					move(-1, 0, '^');
				else if(curCommand == 'D')
					move(1, 0, 'v');
				else if(curCommand == 'L')
					move(0, -1, '<');
				else if(curCommand == 'R')
					move(0, 1, '>');
				else {
					shoot();
				}
			}
			for(int i=0; i<H; i++) {
				for(int j=0; j<W; j++) {
					sb.append(map[i][j]);
				}
				sb.append("\n");
			}
			
		}
		System.out.println(sb);
	}
	static void move(int dr, int dc, char nextTank) {
		int nr = r + dr;
		int nc = c + dc;
		if(nr < 0 || nr >= H || nc < 0 || nc >= W)  {
			map[r][c] = nextTank;
			tank = nextTank;
			return;
		}
			
		if(map[nr][nc] == '-' || map[nr][nc] == '*' || map[nr][nc] == '#') {
			map[r][c] = nextTank;
			tank = nextTank;
			return;
		}
			
		map[nr][nc] = nextTank;
		map[r][c] = '.';
		r = nr;
		c = nc;
		tank = nextTank;
	}
	static void shoot() {
		int dr, dc, boomR, boomC;
		boomR = r;
		boomC = c;
		if(tank == '<') {
			dr = 0;
			dc = -1;
		}
		else if(tank == '>') {
			dr = 0;
			dc = 1;
		}
		else if(tank == '^') {
			dr = -1;
			dc = 0;
		}
		else {
			dr = 1;
			dc = 0;
		}
		
		if(tank == '<' || tank == '>') {
			int nc = boomC;
			while(true) {
				nc = nc + dc;
				if(nc < 0 || nc >= W)
					break;
				if(map[boomR][nc] == '#')
					break;
				if(map[boomR][nc] == '*') {
					map[boomR][nc] = '.';
					break;
				}
			}
			
		}
		else {
			int nr = boomR;
			while(true) {
				nr = nr + dr;
				if(nr < 0 || nr >= H)
					break;
				if(map[nr][boomC] == '#')
					break;
				if(map[nr][boomC] == '*') {
					map[nr][boomC] = '.';
					break;
				}
			}
		}
		
	}
}
