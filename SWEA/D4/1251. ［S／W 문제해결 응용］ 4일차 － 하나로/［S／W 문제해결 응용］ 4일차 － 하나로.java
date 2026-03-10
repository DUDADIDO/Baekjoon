import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {
	static class Edge implements Comparable<Edge> {
		int target;
		double weight;

		public Edge(int target, double weight) {
			super();
			this.target = target;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return Double.compare(this.weight, o.weight);
		}

	}

	static int v;
	static List<List<Edge>> graph;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			st = new StringTokenizer(br.readLine());
			v = Integer.parseInt(st.nextToken());

			int[][] islands = new int[v][2];
			graph = new ArrayList<>();
			
			st = new StringTokenizer(br.readLine());
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			for(int i=0; i<v; i++) {
				islands[i][0] = Integer.parseInt(st.nextToken());
				islands[i][1] = Integer.parseInt(st2.nextToken());
				graph.add(new ArrayList<>());
			}

			double e = Double.parseDouble(br.readLine());
			for(int i=0; i<v-1; i++) {
				for(int j=i; j<v; j++) {
					double dist = getDistance(islands[i][0], islands[i][1], islands[j][0], islands[j][1]);
					double weight = e * Math.pow(dist, 2);
					graph.get(i).add(new Edge(j, weight));
					graph.get(j).add(new Edge(i, weight));
				}
			}
			
			long result = Math.round(prim(0));
			sb.append(result).append("\n");
		}
		System.out.println(sb);
	}
	
	static double prim(int start) {
		PriorityQueue<Edge> pq = new PriorityQueue<>((o1, o2) -> Double.compare(o1.weight, o2.weight));
		boolean[] visited = new boolean[v];
		visited[start] = true;
		double result = 0;
		int count = 0;
		for(Edge edge : graph.get(start)) pq.offer(edge);
		
		while(!pq.isEmpty()) {
			Edge cur = pq.poll();
			if(visited[cur.target]) continue;
			
			visited[cur.target] = true;
			result += cur.weight;
			count ++;
			
			if(count == v-1) return result;
			
			for(Edge edge : graph.get(cur.target)) pq.offer(edge);
		}
		return -1;
		
		
	}
	
	static double getDistance(int x1, int y1, int x2, int y2) {
		return Math.sqrt(Math.pow(x1-x2, 2) + Math.pow(y1-y2, 2));
	}
}
