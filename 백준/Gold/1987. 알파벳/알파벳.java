import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static char[][] map;
	static boolean[] visited;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static int max, rSize, cSize;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		rSize = Integer.parseInt(st.nextToken());
		cSize = Integer.parseInt(st.nextToken());
		
		map = new char[rSize][cSize];
		visited = new boolean[32];
		max = Integer.MIN_VALUE;
		
		for(int i=0; i<rSize; i++) {
			map[i] = br.readLine().toCharArray();
		}
		visited[map[0][0]-'A'] = true;
		dfs(0, 0, 1);
		System.out.println(max);
	}
	
	static void dfs(int r, int c, int cnt) {
		
		
		boolean flag = false;
		
		for(int i=0; i<4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			
			if(nr < 0 || nr >= rSize || nc < 0 || nc >= cSize) continue;
			if(visited[map[nr][nc]-'A']) continue;
			flag = true;
			visited[map[nr][nc]-'A'] = true;
			dfs(nr, nc, cnt+1);
			visited[map[nr][nc]-'A'] = false;
		}
		
		if(!flag) {
			max = Math.max(max, cnt);
			return;
		}
	}
}
