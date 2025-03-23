import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static char[][] graph;
    static int[][] visited;
    static int sheepCount = 0;
    static int wolfCount = 0;

    public static void BFS(int a, int b) {
        int wolfCnt = 0;
        int sheepCnt = 0;
        int[][] dirs = {{1,0}, {-1,0}, {0,1}, {0,-1}};
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{a, b});
        visited[a][b] = 1;

        if (graph[a][b] == 'v') wolfCnt++;
        else if (graph[a][b] == 'o') sheepCnt++;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];

            for (int[] dir : dirs) {
                int newX = x + dir[0];
                int newY = y + dir[1];

                if (newX >= 0 && newX < graph.length && newY >= 0 && newY < graph[0].length) {
                    if (visited[newX][newY] == 0 && graph[newX][newY] != '#') {
                        visited[newX][newY] = 1;

                        if (graph[newX][newY] == 'v')
                            wolfCnt++;
                        else if (graph[newX][newY] == 'o')
                            sheepCnt++;

                        q.add(new int[]{newX, newY});
                    }
                }
            }
        }

        if (sheepCnt > wolfCnt) {
            wolfCount -= wolfCnt;
        } else {
            sheepCount -= sheepCnt;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int R = sc.nextInt();
        int C = sc.nextInt();

        graph = new char[R][C];
        visited = new int[R][C];
        for(int i = 0; i < R; i++) {
            String line = sc.next(); // 또는 sc.nextLine(); ← 아래 설명 참고
            for(int j = 0; j < C; j++) {
                char tmp = line.charAt(j);
                if(tmp == 'o')
                    sheepCount++;
                else if(tmp == 'v')
                    wolfCount++;
                graph[i][j] = tmp;
            }
        }

        for(int i=0; i<R; i++) {
            for(int j=0; j<C; j++) {
                if(graph[i][j] == 'v' || graph[i][j] == 'o') {
                    if(visited[i][j] == 0) {
                        BFS(i, j);
                    }
                }
            }
        }

        System.out.println(sheepCount + " " + wolfCount);

    }
}