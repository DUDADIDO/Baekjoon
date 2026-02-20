import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static List<List<Integer>> graph;
	static int[] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		graph = new ArrayList<>();
		visited = new int[n+1];
		Arrays.fill(visited, -1);
		for(int i=0; i<=n; i++) {
			graph.add(new ArrayList<>());
		}
		int m = Integer.parseInt(br.readLine());
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			graph.get(u).add(v);
			graph.get(v).add(u);
		}
		
		bfs(start);
		StringBuilder sb = new StringBuilder();
		sb.append(visited[end]);
		System.out.println(sb);
	}
	
	static void bfs(int s) {
		visited[s] = 0;
		Queue<Integer> q = new LinkedList<>();
		q.add(s);
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			for(int v : graph.get(cur)) {
				if(visited[v] > -1) continue;
				visited[v] = visited[cur] + 1;
				q.add(v);
			}
		}
	}
}
