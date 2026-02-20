import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	static List<List<Integer>> graph;
	static int[] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		for(int tc=1; tc<=10; tc++) {
			sb.append("#").append(tc).append(" ");
			graph = new ArrayList<>();
			for(int i=0; i<=100; i++) {
				graph.add(new ArrayList<>());
			}
			visited = new int[101];
			Arrays.fill(visited, -1);
			st = new StringTokenizer(br.readLine());
			int size = Integer.parseInt(st.nextToken());
			int start = Integer.parseInt(st.nextToken());
			int max = Integer.MIN_VALUE;
			int maxNode = 0;
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<size/2; i++) {
				int u = Integer.parseInt(st.nextToken());
				int v = Integer.parseInt(st.nextToken());
//				if(graph.get(u).contains(v)) continue;
				graph.get(u).add(v);
			}
			bfs(start);
			for(int i=1; i<=100; i++) {
				if(visited[i] >= max) {
					max = visited[i];
					maxNode = i;
				}
			}
			sb.append(maxNode).append("\n");
		}
		System.out.println(sb);	
	}
	static void bfs(int s) {
		visited[s] = 0;
		Queue<Integer> q = new LinkedList<>();
		q.offer(s);
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			for(int v : graph.get(cur)) {
				if(visited[v] > -1) continue;
				visited[v] = visited[cur]+1;
				q.offer(v);
			}
		}
	}
	
}
