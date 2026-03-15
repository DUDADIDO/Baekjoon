import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static class Edge implements Comparable<Edge> {
        int target, weight;

        Edge(int target, int weight) {
            this.target = target;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.weight, o.weight);
        }
    }
    static int v, e;
    static List<List<Edge>> graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
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
        prim(1);

    }
    static void prim(int start) {
        boolean[] visited = new boolean[v+1];
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(start, 0));

        int cnt = 0;
        int totalWeight = 0;
        while(!pq.isEmpty()) {
            Edge cur = pq.poll();

            if(visited[cur.target]) continue;

            visited[cur.target] = true;
            totalWeight += cur.weight;
            cnt++;

            if(cnt == v) break;
            for(Edge edge : graph.get(cur.target)) {
                if(visited[edge.target]) continue;
                pq.offer(edge);
            }
        }
        System.out.println(totalWeight);
    }
}
