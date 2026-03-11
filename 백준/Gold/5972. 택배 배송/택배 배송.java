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
		int target, weight;
		
		public Edge(int target, int weight) {
			super();
			this.target = target;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.weight, o.weight);
		}

	}
	
	static List<Edge>[] graph;
	static int n, m;
	static int[] dist;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		graph = new ArrayList[n+1];
		for(int i=1; i<=n; i++) {
			graph[i] = new ArrayList<>();
		}
		dist = new int[n+1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			graph[u].add(new Edge(v, w));
			graph[v].add(new Edge(u, w));
		}
		
		dijkstra(1);
		System.out.println(dist[n]);
	}
	
	static void dijkstra(int start) {
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		dist[start] = 0;
		pq.offer(new Edge(start, 0));
		while(!pq.isEmpty()) {
			Edge cur = pq.poll();
			if(dist[cur.target] < cur.weight) continue;
			for(Edge edge : graph[cur.target]) {
				int nextDist = dist[cur.target] + edge.weight;
				if(nextDist < dist[edge.target]) {
					dist[edge.target] = nextDist;
					pq.offer(new Edge(edge.target, nextDist));
				}
			}
		}
	}
}
