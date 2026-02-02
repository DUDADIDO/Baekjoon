import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int[][] graph;
	static StringBuilder sb = new StringBuilder();
	
	static void quadTree(int y, int x, int size) {
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
			int nextSize = size/2;
			sb.append("(");
			quadTree(y, x, nextSize);
			quadTree(y, x+nextSize, nextSize);
			quadTree(y+nextSize, x, nextSize);
			quadTree(y+nextSize, x+nextSize, nextSize);
			sb.append(")");
			return;
		}		
		sb.append(type);
		
		
		
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));;
		
		int n = Integer.parseInt(br.readLine());
		graph = new int[n][n];
		for(int i=0; i<n; i++) {
			String input = br.readLine();
			for(int j=0; j<n; j++) {
				graph[i][j] = Character.getNumericValue(input.charAt(j));
			}
		}
		quadTree(0, 0, n);
		System.out.println(sb);
		
	}
}
