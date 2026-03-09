import java.util.List;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	static char[][] map;
	static boolean[][] visited;
	static int n, cnt;
	static int[] dr = { -1, 1, 0, 0, -1, -1, 1, 1 };
	static int[] dc = { 0, 0, -1, 1, -1, 1, 1, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			n = Integer.parseInt(br.readLine());
			map = new char[n][n];
			visited = new boolean[n][n];
			for (int i = 0; i < n; i++) {
				map[i] = br.readLine().toCharArray();
			}

			cnt = 0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (map[i][j] == '.' && !visited[i][j])
						bfs(i, j);

				}
			}
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (!visited[i][j] && map[i][j] == '.')
						cnt++;
				}
			}
			sb.append(cnt).append("\n");
		}
		System.out.println(sb);
	}

	static void bfs(int r, int c) {
		for (int d = 0; d < 8; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];

			if (nr < 0 || nr >= n || nc < 0 || nc >= n)
				continue;
			if (map[nr][nc] == '*')
				return;
		}
//		System.out.println("통과요 r: " + r + ", c: " + c);
		cnt++;
		Queue<int[]> q = new LinkedList<>();
		visited[r][c] = true;
		q.offer(new int[] { r, c });
		List<int[]> list = new ArrayList<>();
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			int cr = cur[0];
			int cc = cur[1];
//			System.out.println("r: " + cr + ", c: " + cc);
			boolean flag = false;
			for (int d = 0; d < 8; d++) {
				int nr = cr + dr[d];
				int nc = cc + dc[d];
				if (nr < 0 || nr >= n || nc < 0 || nc >= n || visited[nr][nc])
					continue;
				if (map[nr][nc] == '*') {
					flag = true;
					break;
				}
				
				list.add(new int[] { nr, nc });
			}
			if (!flag) {
				for (int[] tmp : list) {
					visited[tmp[0]][tmp[1]] = true;
					q.offer(new int[] { tmp[0], tmp[1] });
				}
			}
			list.clear();
		}

	}

}
