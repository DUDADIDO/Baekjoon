import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static class Edge implements Comparable<Edge> {
		int start, target;
		double weight;
		
		Edge(int start, int target, double weight) {
			this.start = start;
			this.target = target;
			this.weight = weight;
		}
		@Override
		public int compareTo(Edge o) {
			return Double.compare(this.weight, o.weight);
		}
		
	}
	
	static int[] parents;
	static List<Edge> list;
	static int n;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		list = new ArrayList<>();
		parents = new int[n];
		double[][] stars = new double[n][2];
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			stars[i][0] = Double.parseDouble(st.nextToken());
			stars[i][1] = Double.parseDouble(st.nextToken());
			parents[i] = i;
		}
		for(int i=0; i<n-1; i++) {
			for(int j=i+1; j<n; j++) {
				double weight = getDist(stars[i][0], stars[i][1], stars[j][0], stars[j][1]);
				list.add(new Edge(i, j, weight));
			}
		}
		double result = kruskal();
		System.out.printf("%.2f", result);
	}
	static double kruskal() {
		Collections.sort(list);
		int count = 0;
		double result = 0;
		for(Edge edge : list) {
			if(union(edge.start, edge.target)) {
				count++;
				result += edge.weight;
			}
			if(count == n-1) return result;
		}
		return -1;
	}
	static int find(int a) {
		if(parents[a] == a) return a;
		return parents[a] = find(parents[a]);
	}
	static boolean union(int a, int b) {
		int rootA = find(a);
		int rootB = find(b);
		if(rootA != rootB) {
			parents[rootB] = rootA;
			return true;
		}
		return false;
	}
	static double getDist(double x1, double y1, double x2, double y2) {
		return Math.sqrt(Math.pow(x1-x2, 2) + Math.pow(y1-y2, 2));
	}
}
