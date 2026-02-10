import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
	static int[][] map;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static List<int[]> list = new ArrayList<>();
	static int processNum, maxProSum, minWireSum, n;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		for(int tc=1; tc<=T; tc++) {
			sb.append("#").append(tc).append(" ");
			list.clear();
			n = Integer.parseInt(br.readLine());
			map = new int[n][n];
			maxProSum = Integer.MIN_VALUE;
			minWireSum = Integer.MAX_VALUE;
			processNum = 0;
			for(int i=0; i<n; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<n; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if(map[i][j] == 1) {
						processNum++;
						list.add(new int[] {i, j});
					}
				}
			}
			connect(0, 0, 0);
			sb.append(minWireSum).append("\n");
			
		}
		System.out.println(sb);
	}
	static void connect(int proNum, int wireSum, int coreCnt) {

		if(proNum == processNum) {
			if(coreCnt > maxProSum)  {
				minWireSum = wireSum;
				maxProSum = coreCnt;
			}
			else if(coreCnt == maxProSum) 
				minWireSum = Math.min(wireSum, minWireSum);
			return;
		}
		int cR = list.get(proNum)[0];
		int cC = list.get(proNum)[1];
		if(cR==0 || cR==n-1 || cC==0 || cC==n-1) {
			connect(proNum+1, wireSum, coreCnt+1);
			return;
		}
		for(int i=0; i<4; i++) {
			int[] dest = connectWire(proNum, i);
			if(dest[2] > 0) {
				connect(proNum+1, wireSum + dest[2], coreCnt+1);
				disConnectWire(proNum, i, dest[0], dest[1], dest[2]);	
			}
		}
		connect(proNum+1, wireSum, coreCnt);
	}
	static int[] connectWire(int proNum, int dir) {
		int cR = list.get(proNum)[0];
		int cC = list.get(proNum)[1];
		int wire = 0;
		while(true) {
			int nextR = cR + dr[dir];
			int nextC = cC + dc[dir];
			
			if(nextR<0 || nextR>=n || nextC<0 || nextC>=n) {
				break;
			}
			if(map[nextR][nextC] != 0)
				return new int[] {cR, cC, 0};
			wire++;
			cR = nextR;
			cC = nextC;
		}
		//연결 해야 할 때
		cR = list.get(proNum)[0];
		cC = list.get(proNum)[1];
		for(int i=0; i<wire; i++) {
			cR += dr[dir];
			cC += dc[dir];
			map[cR][cC] = 2;
		}
		return new int[] {cR, cC, wire};
	}
	static void disConnectWire(int proNum, int dir, int destR, int destC, int wire) {
		int cR = list.get(proNum)[0];
		int cC = list.get(proNum)[1];
		for(int i=0; i<wire; i++) {
			cR += dr[dir];
			cC += dc[dir];
			map[cR][cC] = 0;
		}
	}
}
