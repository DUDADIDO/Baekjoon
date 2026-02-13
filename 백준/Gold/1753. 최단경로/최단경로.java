import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node implements Comparable<Node>{
	int index;
	int weight;
	
	Node(int index, int weight) {
		this.index = index;
		this.weight = weight;
	}
	@Override
	public int compareTo(Node o) {
		// TODO Auto-generated method stub
		return this.weight - o.weight;
	}
}

public class Main {
	static int[] distance;
	static List<List<Node>> graph = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		int start = Integer.parseInt(br.readLine());
		distance = new int[n+1];
		Arrays.fill(distance, Integer.MAX_VALUE);
		for(int i=0; i<=n; i++) {
			graph.add(new ArrayList<>());
		}
		for(int i=0; i<r; i++) {
			st = new StringTokenizer(br.readLine());
			
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			graph.get(u).add(new Node(v, w));
		}
		dijksatra(start);
		for(int i=1; i<=n; i++) {
			if(distance[i] == Integer.MAX_VALUE)
				System.out.println("INF");
			else
				System.out.println(distance[i]);
		}
	}
	static void dijksatra(int start) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		distance[start] = 0;
		pq.add(new Node(start, 0));
		while(!pq.isEmpty()) {
			Node cur = pq.poll();
			int curIdx = cur.index;
			int curWeight = cur.weight;
			if(curWeight > distance[curIdx]) {
				continue;
			}
			for(Node neighbor : graph.get(curIdx)) {
				int cost = distance[curIdx] + neighbor.weight;
				if(cost < distance[neighbor.index]) {
					distance[neighbor.index] = cost;
					pq.add(new Node(neighbor.index, cost));
				}
				
			}
		}
	}
}
