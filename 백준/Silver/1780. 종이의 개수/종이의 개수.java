import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[][] graph;
	static int minusCnt, zeroCnt, oneCnt;
	static StringBuilder sb = new StringBuilder();
	
	static void papaerCheck(int y, int x, int size) {
		boolean flag = false;
		int type = graph[y][x];
		for(int i=y; i<y+size; i++) {
			for(int j=x; j<x+size; j++) {
				if(graph[i][j] != type) {
					flag = true;
					break;
				}
			}
			if(flag)
				break;
		}
		if(flag) {
			int nextSize = size/3;
			papaerCheck(y, x, nextSize);
			papaerCheck(y, x+nextSize, nextSize);
			papaerCheck(y, x+(nextSize*2), nextSize);

			papaerCheck(y+nextSize, x, nextSize);
			papaerCheck(y+nextSize, x+nextSize, nextSize);
			papaerCheck(y+nextSize, x+(nextSize*2), nextSize);

			papaerCheck(y+(nextSize*2), x, nextSize);
			papaerCheck(y+(nextSize*2), x+nextSize, nextSize);
			papaerCheck(y+(nextSize*2), x+(nextSize*2), nextSize);

			return;
		}		
		if(type == -1)
			minusCnt++;
		else if(type == 0)
			zeroCnt++;
		else
			oneCnt++;
		
		
		
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));;
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		graph = new int[n][n];
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		papaerCheck(0, 0, n);
		sb.append(minusCnt).append("\n").append(zeroCnt).append("\n").append(oneCnt);
		System.out.println(sb);
		
	}
}
