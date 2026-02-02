import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int whiteCnt;
	static int blueCnt;
	static int[][] graph;
	
	static void check(int y, int x, int size) {
		boolean flag = false;
		int type = graph[y][x];
		for(int i=y; i<y+size; i++) {
			for(int j=x; j<x+size; j++) {
				if(graph[i][j] != type) {
					flag = true;
					break;
				}
				if(flag)
					break;
			}
		}
		if(flag) {
			int nextSize = size / 2;
			check(y, x, nextSize); // 왼쪽 위
			check(y, x+nextSize, nextSize); // 오른쪽 위
			check(y+nextSize, x, nextSize); // 왼쪽 아래
			check(y+nextSize, x+nextSize, nextSize); // 오른쪽 아래
			return;
		}
		if(type == 0)
			whiteCnt++;
		else
			blueCnt++;
		
		return;
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		
		graph = new int[n][n];
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		check(0, 0, n);
		sb.append(whiteCnt).append("\n").append(blueCnt);
		System.out.println(sb);
		
		
	}
}
