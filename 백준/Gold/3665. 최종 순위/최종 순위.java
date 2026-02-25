import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[][] map;
	static int n;
	static int[] inDegree;
	static List<Integer> list;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			n = Integer.parseInt(br.readLine());
			map = new int[n+1][n+1];
			inDegree = new int[n+1];
			list = new ArrayList<>();
			int[] tmp = new int[n];
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<n; i++) {
				tmp[i] = Integer.parseInt(st.nextToken());
			}
			for(int i=0; i<n; i++) {
				for (int j = i + 1; j < n; j++) {
					int u = tmp[i];
					int v = tmp[j];
					map[u][v] = 1;
					inDegree[v]++;
				}
			}

			int m = Integer.parseInt(br.readLine());
			for(int i=0; i<m; i++) {
				st = new StringTokenizer(br.readLine());
				int u = Integer.parseInt(st.nextToken());
				int v = Integer.parseInt(st.nextToken());

				if(map[u][v] == 1) {
					map[u][v] = 0;
					map[v][u] = 1;
					inDegree[v]--;
					inDegree[u]++;
				}
				else {
					map[u][v] = 1;
					map[v][u] = 0;
					inDegree[u]--;
					inDegree[v]++;
				}

			}
			// 여기까지 뒤집기 완료
			// inDegree가 0인거 부터 큐에 넣으면서 검증
			// 단 inDegree가 0인 인덱스가 2개 이상 존재하면 모호한것.
			// 모든 노드를 다 탐색하지 못한다면 확정짓지 못하는것
			
			String result = bfs();
			sb.append(result).append("\n");
		}
		System.out.println(sb);
	}
	static String bfs() {
		
		StringBuilder sb = new StringBuilder();
		Queue<Integer> q = new LinkedList<>();
		for(int i=1; i<=n; i++) {
			if(inDegree[i] == 0) {
				q.add(i);
				break;
			}
		}
		for(int i=0; i<n; i++) {
			if(q.isEmpty()) {
				return "IMPOSSIBLE";
			}
			if(q.size() > 1) {
				return "?";
			}
			int cur = q.poll();
			list.add(cur);
			sb.append(cur).append(" ");
			for(int j=1; j<=n; j++) {
				if(map[cur][j] > 0) {
					inDegree[j]--;
					if(inDegree[j] == 0) {
						q.add(j);						
					}

				}
			}
			
		}
		return sb.toString();
	}

}
