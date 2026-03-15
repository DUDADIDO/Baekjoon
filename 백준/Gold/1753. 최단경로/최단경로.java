import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Edge implements Comparable<Edge> {
        int target, weight;

        public Edge(int target, int weight) {
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
    static int[] distance;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        graph = new ArrayList<>();

        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        for(int i=0; i<=v; i++) {
            graph.add(new ArrayList<>());
        }
        int s = Integer.parseInt(br.readLine());
        distance = new int[v+1];
        Arrays.fill(distance, 1000000000);
        for(int i=0; i<e; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int target = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            graph.get(start).add(new Edge(target, weight));
        }

        dijkstra(s);
        for(int i=1; i<=v; i++) {
            if(distance[i] == 1000000000) {
                System.out.println("INF");
            }
            else {
                System.out.println(distance[i]);
            }
        }

    }

    static void dijkstra(int start) {
        distance[start] = 0;
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(start, 0));
        while(!pq.isEmpty()) {
            Edge cur = pq.poll();

            if(cur.weight > distance[cur.target]) continue;
            for(Edge edge : graph.get(cur.target)) {
                int nextDist = distance[cur.target] + edge.weight;
                if(nextDist < distance[edge.target]) {
                    distance[edge.target] = nextDist;
                    pq.offer(new Edge(edge.target, nextDist));
                }
            }

        }
    }
}
