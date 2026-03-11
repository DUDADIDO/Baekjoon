import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//메모리: , 실행시간:  ms
public class Solution {
	static class Edge {
		int target, weight;
		
		public Edge(int target, int weight) {
			super();
			this.target = target;
			this.weight = weight;
		}	
	}
	static List<List<Edge>> graph;
	static int v;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");

			st = new StringTokenizer(br.readLine());
			v = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			graph = new ArrayList<>();
			for(int i=0; i<=v; i++) {
				graph.add(new ArrayList<>());
			}
			for(int i=0; i<e; i++) {
				st = new StringTokenizer(br.readLine());
				int start = Integer.parseInt(st.nextToken());
				int target = Integer.parseInt(st.nextToken());
				int weight = Integer.parseInt(st.nextToken());
				
				graph.get(start).add(new Edge(target, weight));
				graph.get(target).add(new Edge(start, weight));
			}
			sb.append(prim(1)).append("\n");
			
		}
		System.out.println(sb);
	}
	static long prim(int start) {
		int count = 0;
		long result = 0;
		boolean[] visited = new boolean[v+1];
		int[] minDist = new int[v+1];
		Arrays.fill(minDist, Integer.MAX_VALUE);
		visited[start] = true;
		PriorityQueue<Edge> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.weight, o2.weight));
		for(Edge edge : graph.get(start)) pq.offer(edge);
		
		while(!pq.isEmpty()) {
			Edge cur = pq.poll();
			
			if(visited[cur.target]) continue;
			
			visited[cur.target] = true;
			count++;
			result += cur.weight;
			for(Edge edge : graph.get(cur.target)) {
				if(!visited[edge.target] && edge.weight < minDist[edge.target]) {
					minDist[edge.target]= edge.weight;
					pq.offer(edge);
				}
			}
			
			if(count == v-1) return result; 
		}
		return -1;
	}

}
