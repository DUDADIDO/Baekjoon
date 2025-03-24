import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int[][] graph;
    static int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    static Queue<int[]> queue = new LinkedList<>();

    public static void BFS() {
        while(!queue.isEmpty()) {
            int[] cur = queue.poll();;
            int curX = cur[0];
            int curY = cur[1];
            for(int[] dir : dirs) {
                int nextX = curX + dir[0];
                int nextY = curY + dir[1];
                if(nextX < 0 || nextX >= graph.length || nextY < 0 || nextY >= graph[0].length) {
//                    System.out.println("nextX : " + nextX + " nextY : " + nextY + "    continue");
                    continue;
                }
                if(graph[nextX][nextY] == 0) {
                    graph[nextX][nextY] = graph[curX][curY] + 1;
//                    System.out.println("add new queue");
                    queue.add(new int[]{nextX, nextY});
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        graph = new int[m][n];
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; j++) {
                graph[i][j] = sc.nextInt();
                if(graph[i][j] == 1) {
                    queue.add(new int[]{i, j});

                }
            }
        }
        BFS();
//        for(int i=0; i<m; i++) {
//            for(int j=0; j<n; j++) {
//                System.out.print(graph[i][j] + " ");
//            }
//            System.out.println();
//        }

        boolean flag = false;
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(graph[i][j] == 0) {
                    flag = true;
                }
            }
        }
        if(flag) {
            System.out.println("-1");
        }
        else {
            int max = Integer.MIN_VALUE;
            for(int i=0; i<m; i++) {
                for(int j=0; j<n; j++) {
                    if(graph[i][j] > max) {
                        max = graph[i][j];
                    }
                }
            }
            System.out.println(max-1);
        }


    }
}