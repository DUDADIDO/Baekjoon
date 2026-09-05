import java.util.*;
class Solution {
    static class Node implements Comparable<Node> {
        int to;
        int cost;
        
        Node(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
        
        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }
    
    static List<Node>[] graph;
    static boolean[] visited;
    static int dist[];
    
    public int solution(int N, int[][] road, int K) {
        int answer = 0;

        
        graph = new ArrayList[N+1];
        visited = new boolean[N+1];
        dist = new int[N+1];
        
        for(int i=1; i<=N; i++) {
            graph[i] = new ArrayList<>();
        }
        Arrays.fill(dist, Integer.MAX_VALUE);
        
        for(int i=0; i<road.length; i++) {
            int s = road[i][0];
            int t = road[i][1];
            int c = road[i][2];
            
            graph[s].add(new Node(t, c));
            graph[t].add(new Node(s, c));
        }
        dijkstra(1);
        
        for(int i=1; i<=N; i++) {
            if(dist[i] <= K) answer++;
        }
        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("Hello Java");

        return answer;
    }
    
    static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        
        dist[start] = 0;
        pq.offer(new Node(start, 0));
        
        while(!pq.isEmpty()) {
            Node cur = pq.poll();
            
            int now = cur.to;
            int cost = cur.cost;
            
            if(cost > dist[now]) continue;
            
            for(Node next : graph[now]) {
                int nextCost = cost + next.cost;
                
                if(nextCost < dist[next.to]) {
                    dist[next.to] = nextCost;
                    pq.offer(new Node(next.to, nextCost));
                }
            }
        }
        
        
    }
}