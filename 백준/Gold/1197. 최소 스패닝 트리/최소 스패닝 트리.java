import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static class Edge {
		int target;
		int weight;
		
		Edge(int target, int weight) {
			this.target = target;
			this.weight = weight;
		}
	}
	static List<List<Edge>> graph;
	static boolean[] visited;
	static int v;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		v = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());
		graph = new ArrayList<>();
		visited = new boolean[v+1];
		for(int i=0; i<=v; i++) {
			graph.add(new ArrayList<>());
		}
		for(int i=0; i<e; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			graph.get(start).add(new Edge(end, weight));
			graph.get(end).add(new Edge(start, weight));
		}
		long result = prim(1);
		
		System.out.println(result);
		
	}
	static long prim(int start) {
		long result = 0;
		int count = 0;
		PriorityQueue<Edge> pq = new PriorityQueue<>((o1, o2) ->  {
			return o1.weight - o2.weight;
		});
		visited[start] = true;
		for(Edge edge : graph.get(start)) {
			pq.offer(edge);
		}
		while(!pq.isEmpty()) {
			Edge cur = pq.poll();
			if(visited[cur.target]) continue;
			count++;
			visited[cur.target] = true; 
			result += cur.weight;
			if(count == v-1) break;
			for(Edge edge : graph.get(cur.target)) pq.offer(edge);
		}
		return result;
	}
}
