import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
//	static class Edge {
//		int u;
//		int v;
//		public Edge(int u, int v) {
//			this.u = u;
//			this.v = v;
//		}
//	}
	static int minGap;
	static List<List<Integer>> graph;
	static int[] population;
	static boolean[] selected;
	static int n;
	public static void main(String[] args) throws IOException {	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		minGap = Integer.MAX_VALUE;
		n = Integer.parseInt(br.readLine());
		graph = new ArrayList<>();
		population = new int[n+1];
		selected = new boolean[n+1];
		st = new StringTokenizer(br.readLine());
		graph.add(new ArrayList<>());
		for(int i=1; i<=n; i++) {
			graph.add(new ArrayList<>());
			population[i] = Integer.parseInt(st.nextToken());
		}
		for(int i=1; i<=n; i++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			for(int j=0; j<num; j++) {
				int u = i;
				int v = Integer.parseInt(st.nextToken());
				graph.get(u).add(v);
				graph.get(v).add(u);
			}
		}
		dfs(1);
		if(minGap == Integer.MAX_VALUE)
			minGap = -1;
		System.out.println(minGap);
		
	}
	static void dfs(int L) {
		if(L == n+1) {
			int sumA = 0;
			int sumB = 0;
			List<Integer> teamA = new ArrayList<>();
			List<Integer> teamB = new ArrayList<>();
			for(int i=1; i<=n; i++) {
				if(selected[i]) {
					teamA.add(i);
				}
				else {
					teamB.add(i);
				}
			}
			if(teamA.size() == 0 || teamB.size() == 0)
				return;
			if(!bfs(teamA, true) || !bfs(teamB, false))
				return;
			for(int n : teamA) {
				sumA += population[n];
			}
			for(int n : teamB) {
				sumB += population[n];
			}
			minGap = Math.min(minGap, Math.abs(sumA - sumB));
			return;
		}
		selected[L] = true;
		dfs(L+1);
		selected[L] = false;
		dfs(L+1);
		
	}
	static boolean bfs(List<Integer> team, boolean teamFlag) {
		boolean[] visited = new boolean[n+1];
		Queue<Integer> q = new LinkedList<>();
		visited[team.get(0)] = true;
		q.add(team.get(0));
		while(!q.isEmpty()) {
			int cur = q.poll();
			for(int i=0; i<graph.get(cur).size(); i++) {
				if(selected[graph.get(cur).get(i)] == teamFlag && visited[graph.get(cur).get(i)] == false) {
					visited[graph.get(cur).get(i)] = true;
					q.add(graph.get(cur).get(i));
				}
			}
		}
		for(int i=0; i<team.size(); i++) {
			if(!visited[team.get(i)])
				return false;
		}
		return true;
	}
}
