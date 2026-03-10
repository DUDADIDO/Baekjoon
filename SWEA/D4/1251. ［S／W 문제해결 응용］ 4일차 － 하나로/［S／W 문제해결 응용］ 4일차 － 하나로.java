import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
	static class Edge implements Comparable<Edge> {
		int start, target;
		double weight;

		public Edge(int start, int target, double weight) {
			super();
			this.start = start;
			this.target = target;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return Double.compare(this.weight, o.weight);
		}

	}

	static int v;
	static int[] parents;
	static List<Edge> list;
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
			
			list = new ArrayList<>();
			parents = new int[v + 1];
			Arrays.fill(parents, -1);
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<v; i++) {
				islands[i][0] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<v; i++) {
				islands[i][1] = Integer.parseInt(st.nextToken());
			}
			double e = Double.parseDouble(br.readLine());
			for(int i=0; i<v-1; i++) {
				for(int j=i; j<v; j++) {
					double dist = getDistance(islands[i][0], islands[i][1], islands[j][0], islands[j][1]);
					double weight = e * Math.pow(dist, 2);
					list.add(new Edge(i, j, weight));
				}
			}
			
			long result = Math.round(kruskal());
			sb.append(result).append("\n");
		}
		System.out.println(sb);
	}
	
	static double kruskal() {
		Collections.sort(list);
		double result = 0;
		int count = 0;
		
		for(Edge edge : list) {
			if(!union(edge.start, edge.target)) continue;
			result += edge.weight;
			count++;
			
			if(count == v-1) return result;
		}
		return -1;
	}

	static int find(int a) {
		if (parents[a] < 0)
			return a; // 음수면 해당 요소가 집합의 루트
		return parents[a] = find(parents[a]);
	}

	static boolean union(int a, int b) {
		int rootA = find(a);
		int rootB = find(b);
		if (rootA == rootB) // 두 요소가 같은 집합에 속해있다면 union 수행 x
			return false;

		if (parents[rootA] > parents[rootB]) { // 항상 좌측의 집합이 우측보다 더 크도록 조정
			int tmp = rootA;
			rootA = rootB;
			rootB = tmp;
		}
		parents[rootA] += parents[rootB]; // 좌측 집합의 크기에 우측 집합의 크기를 더한다.
		parents[rootB] = rootA; // 우측 집합의 루트를 좌측 집합의 루트로 변경
		return true;
	}
	
	static double getDistance(int x1, int y1, int x2, int y2) {
		return Math.sqrt(Math.pow(x1-x2, 2) + Math.pow(y1-y2, 2));
	}
}
