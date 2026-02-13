import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int minGap;
	static List<List<Integer>> graph;
	static int[] population;
	static boolean[] selected;
	static int n;
	public static void main(String[] args) throws IOException {	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		minGap = Integer.MAX_VALUE; // 최소 차이
		n = Integer.parseInt(br.readLine()); // 구역 개수
		graph = new ArrayList<>(); // 구역들의 연결(간선)을 저장하기 위한 인접리스트
		population = new int[n+1]; // 각 구역의 인구수
		selected = new boolean[n+1]; // 각 구역들이 어느 선거구에 속한건지 구분하기 위한 boolean 배열
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
		if(minGap == Integer.MAX_VALUE) // 최소값이 갱신되지 않았다면, 어떤 경우로든 선거구 2개로 구역을 나눌 수 없음을 의미. -1 출력
			minGap = -1;
		System.out.println(minGap);
		
	}
	static void dfs(int L) { // 구역을 나누기 위한 dfs(부분집합)
		if(L == n+1) {
			calc();
			return;
		}
		selected[L] = true;
		dfs(L+1);
		selected[L] = false;
		dfs(L+1);
		
	}
	static boolean bfs(List<Integer> team, boolean teamFlag) { // 선택된 구역들이 인접해있는지 확인하기 위한 bfs   (큐를 이용한 구현)
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
	static void calc() { // 각 구역의 인구수 계산
		int sumA = 0;
		int sumB = 0;
		List<Integer> teamA = new ArrayList<>();
		List<Integer> teamB = new ArrayList<>();
		for(int i=1; i<=n; i++) {
			if(selected[i]) { // 각 구역의 선거구 구분
				teamA.add(i);
			}
			else {
				teamB.add(i);
			}
		}
		if(teamA.size() == 0 || teamB.size() == 0) // 어느 한 선거구에 구역이 하나도 없다면 종료.
			return;
		if(!bfs(teamA, true) || !bfs(teamB, false)) // 어느 한 선거구의 구역들이 모두 인접한게 아니라면 종료
			return;
		// 인구 수 계산
		for(int n : teamA) {
			sumA += population[n];
		}
		for(int n : teamB) {
			sumB += population[n];
		}
		// 최소 차이 갱신
		minGap = Math.min(minGap, Math.abs(sumA - sumB));
	}
}
