import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static class Edge implements Comparable<Edge> {
		int to, weight;

		public Edge(int to, int weight) {
			super();
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.weight, o.weight);
		}
	}

	static List<Edge>[] graph;
	static int[] dist;
	static int n, m;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		dist = new int[n + 1];
		graph = new ArrayList[n + 1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		for (int i = 1; i <= n; i++)
			graph[i] = new ArrayList<>();
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());

			graph[u].add(new Edge(v, w));
//			graph[v].add(new Edge(u, w));
		}
		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int to = Integer.parseInt(st.nextToken());
		dijkstra(start);
		System.out.println(dist[to]);
	}

	static void dijkstra(int start) {
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		dist[start] = 0;
		pq.offer(new Edge(start, 0));

		while (!pq.isEmpty()) {
			Edge cur = pq.poll();

			if (dist[cur.to] < cur.weight)
				continue;

			for (Edge edge : graph[cur.to]) {
				int nextDist = dist[cur.to] + edge.weight;
				if (nextDist < dist[edge.to]) {
					dist[edge.to] = nextDist;
					pq.offer(new Edge(edge.to, nextDist));
				}
			}
		}
	}
}
