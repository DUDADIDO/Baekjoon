import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int[][] map;
	static int n, x;
	static int cnt;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			st = new StringTokenizer(br.readLine());
			cnt = 0;
			n = Integer.parseInt(st.nextToken());
			x = Integer.parseInt(st.nextToken());
			map = new int[n][n];

			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());

				}
			}
			solve();
			sb.append(cnt).append("\n");
		}
		System.out.println(sb);
	}

	static void solve() {
		for (int r = 0; r < n; r++) { // 가로 쭉
			boolean flag = false;
			boolean[] visited = new boolean[n];
			for (int c = 0; c < n - 1; c++) {
				if (Math.abs(map[r][c] - map[r][c + 1]) > 1) {
					flag = true;
					break;
				}
				if (map[r][c] != map[r][c + 1]) {
					if (map[r][c] > map[r][c + 1]) { // c+1 ~ c+x 까지
						// 만약 c+x가 경계를 벗어나면 break -> 활주로 x
						if (c + x >= n) {
							flag = true;
							break;
						}
						int prev = map[r][c + 1];
						for (int start = c + 1; start <= c + x; start++) {
							// 만약 여기서도 높이 다른게 있다면 break -> 활주로 x
							if (map[r][start] != prev) {
								flag = true;
								break;
							}
							if (visited[start]) {
								flag = true;
								break;
								// 이미 오르막 깔린곳. 안됨
							}
							visited[start] = true;

							prev = map[r][start];
						}
						if (flag)
							break;

					} else { // c ~ c-x+1 까지
								// 만약 c-x+1이 범위를 벗어났다면 break -> 활주로 x
						if (c - x + 1 < 0) {
							flag = true;
							break;
						}
						int prev = map[r][c];
						for (int start = c; start >= c - x + 1; start--) {
							if (map[r][start] != prev) {
								flag = true;
								break;
							}
							if (visited[start]) {
								flag = true;
								break;
								// 이미 오르막 깔린곳. 안됨
							}
							visited[start] = true;

							prev = map[r][start];

						}
						if (flag)
							break;

					}
				}

			}
			if (!flag) {
				cnt++;
			}
		}

		for (int c = 0; c < n; c++) { // 세로 쭉
			boolean flag = false;
			boolean[] visited = new boolean[n];
			for (int r = 0; r < n - 1; r++) {
				if (Math.abs(map[r][c] - map[r + 1][c]) > 1) {
					flag = true;
					break;
				}
				if (map[r][c] != map[r + 1][c]) {
					if (map[r][c] > map[r + 1][c]) { // r+1 ~ r+x 까지
						if (r + x >= n) {
							flag = true;
							break;
						}
						int prev = map[r + 1][c];
						for (int start = r + 1; start <= r + x; start++) {
							// 만약 여기서도 높이 다른게 있다면 break -> 활주로 x
							if (map[start][c] != prev) {
								flag = true;
								break;
							}
							if (visited[start]) {
								flag = true;
								break;
								// 이미 오르막 깔린곳. 안됨
							}
							visited[start] = true;

							prev = map[start][c];
						}
						if (flag)
							break;

					} else { // r ~ r-x+1 까지
						if (r - x + 1 < 0) {
							flag = true;
							break;
						}
						int prev = map[r][c];
						for (int start = r; start >= r - x + 1; start--) {
							if (map[start][c] != prev) {
								flag = true;
								break;
							}
							if (visited[start]) {
								flag = true;
								break;
								// 이미 오르막 깔린곳. 안됨
							}
							visited[start] = true;

							prev = map[start][c];

						}
						if (flag)
							break;
					}
				}
			}
			if (!flag) {
				cnt++;
			}
		}
	}

}
