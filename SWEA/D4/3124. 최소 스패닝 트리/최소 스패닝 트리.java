import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	static class Edge implements Comparable<Edge> {
		int start, target, weight;
		
		public Edge(int start, int target, int weight) {
			super();
			this.start = start;
			this.target = target;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.weight, o.weight);
		}
		
	}
	static int[] parents;
	static Edge[] edges;
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
			edges = new Edge[e];
			parents = new int[v+1];
			Arrays.fill(parents, -1);
			parents[0] = 0;
			for(int i=0; i<e; i++) {
				st = new StringTokenizer(br.readLine());
				int start = Integer.parseInt(st.nextToken());
				int target = Integer.parseInt(st.nextToken());
				int weight = Integer.parseInt(st.nextToken());
				
				edges[i] = new Edge(start, target, weight);
			}
			sb.append(kruskal()).append("\n");
			
		}
		System.out.println(sb);
	}
	static long kruskal() {
		long result = 0;
		int count = 0;
		Arrays.sort(edges);
		
		for(Edge edge : edges) {
			boolean unionResult = union(edge.start, edge.target);
			if(!unionResult) continue;
			result += edge.weight;
			count++;
			
			if(count == v-1) return result;
		}
		return -1;
	}
	static boolean union(int a, int b) {
		int rootA = find(a);
		int rootB = find(b);
		if(rootA == rootB) return false;
		
//		if(parents[rootA] > parents[rootB]) {
//			int tmp = rootA;
//			rootA = rootB;
//			rootB = tmp;
//		}
//		parents[rootA] += parents[rootB];
		parents[rootB] = rootA;
		return true;
	}
	static int find(int a) {
		if(parents[a] < 0) return a;
		return parents[a] = find(parents[a]);
	}

}
