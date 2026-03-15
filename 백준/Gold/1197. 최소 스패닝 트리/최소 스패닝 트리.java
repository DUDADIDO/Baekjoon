import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static class Edge implements Comparable<Edge> {
        int start, target, weight;

        public Edge(int start, int target, int weight) {
            this.start = start;
            this.target = target;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.weight, o.weight);
        }
    }
    static int v, e;
    static int[] parents;
    static List<Edge> list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
list = new ArrayList<>();
        parents = new int[v+1];
        for(int i=0; i<=v; i++) {
            parents[i] = i;
        }

        for(int i=0; i<e; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int target = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            list.add(new Edge(start, target, weight));
        }
        kruskal();
    }
    static void kruskal() {
        int cnt = 0;
        int totalWeight = 0;
        Collections.sort(list);
        for(Edge edge : list) {
            if(find(edge.start) != find(edge.target)) {
                union(edge.start, edge.target);
                totalWeight += edge.weight;
                cnt++;
            }

            if(cnt == v-1) break;
        }
        System.out.println(totalWeight);
    }
    static void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);

        if(rootA == rootB) return;
        parents[rootB] = rootA;
    }
    static int find(int a) {
        if(parents[a] == a) return a;
        return parents[a] = find(parents[a]);
    }
}
