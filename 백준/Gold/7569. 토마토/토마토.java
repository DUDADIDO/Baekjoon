import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static Queue<int[]> queue = new LinkedList<>();
    static int[][][] graph;
    static int[][] dirs = {{1, 0, 0}, {-1, 0, 0}, {0, 1, 0}, {0, -1, 0}, {0, 0, 1}, {0, 0, -1}};
    public static void BFS() {
        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            int curX = cur[0];
            int curY = cur[1];
            int curZ = cur[2];

            for(int[] dir : dirs) {
                int nextX = curX + dir[0];
                int nextY = curY + dir[1];
                int nextZ = curZ + dir[2];
                if(nextZ < 0 || nextZ >= graph[0][0].length || nextY < 0 || nextY >= graph[0].length || nextX < 0 || nextX >= graph.length) {
                    continue;
                }
                if(graph[nextX][nextY][nextZ] == 0) {
                    queue.add(new int[]{nextX, nextY, nextZ});
                    graph[nextX][nextY][nextZ] = graph[curX][curY][curZ] + 1;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int h = sc.nextInt();
        graph = new int[h][n][m];

        for(int i=0; i<h; i++) {
            for(int j=0; j<n; j++) {
                for(int k=0; k<m; k++) {
                    graph[i][j][k] = sc.nextInt();
                    if(graph[i][j][k] == 1) {
                        queue.add(new int[]{i, j, k});
                    }
                }
            }
        }
        BFS();

        int max = Integer.MIN_VALUE;

        for(int i=0; i<h; i++) {
            for(int j=0; j<n; j++) {
                for(int k=0; k<m; k++) {
                    if(graph[i][j][k] > max) {
                        max = graph[i][j][k];
                    }
                    if(graph[i][j][k] == 0) {
                        System.out.println("-1");
                        return;
                    }
                }
            }
        }
        System.out.println(max-1);

    }
}