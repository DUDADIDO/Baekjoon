import java.util.*;
//
class Main {
    static int max = Integer.MIN_VALUE;
    static int[][] originalGraph;

    static int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    public static void BFS(int[][] newWall) {
        int n = originalGraph.length;
        int m = originalGraph[0].length;
        int[][] graph = new int[n][m];
        for (int i = 0; i < n; i++) {
            graph[i] = Arrays.copyOf(originalGraph[i], m);
        }
        for(int i=0; i<3; i++) {
            graph[newWall[i][0]][newWall[i][1]] = 1;
        }
        Queue<int[]> queue = new LinkedList<>();
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(graph[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                }
            }
        }

        while(!queue.isEmpty()) {
            int[] tmp = queue.poll();
            int curX = tmp[0];
            int curY = tmp[1];
            for(int[] dir : dirs) {
                int newX = curX + dir[0];
                int newY = curY + dir[1];
                if(newX < 0 || newX >= graph.length || newY < 0 || newY >= graph[0].length)
                    continue;
                if(graph[newX][newY] == 0) {
                    graph[newX][newY] = 2;
                    queue.add(new int[]{newX, newY});
                }
            }
        }
        int cnt = 0;
        for(int i=0; i<n; ++i) {
            for(int j=0; j<m; ++j) {
                if(graph[i][j] == 0) {
                    cnt++;
                }
            }
        }
        max = Math.max(max, cnt);
    }
    public static void Combination(List<int[]> newWall, int start, int depth, int[][] selected) {
        if(depth == 3) {
            int[][] selectedCopy = new int[3][2];
            for (int i = 0; i < 3; i++) {
                selectedCopy[i] = selected[i].clone();
            }
            BFS(selectedCopy);
            return;
        }

        for(int i=start; i<newWall.size(); ++i) {
            selected[depth] = newWall.get(i).clone();
            Combination(newWall, i + 1, depth + 1, selected);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 행의 개수
        int m = sc.nextInt(); // 열의 개수
        originalGraph = new int[n][m];
        for(int i=0; i<n; ++i) {
            for(int j=0; j<m; ++j) {
                originalGraph[i][j] = sc.nextInt();
            }
        }
        List<int[]> newWall = new ArrayList<>();
        for(int i=0; i<n; ++i) {
            for(int j=0; j<m; ++j) {
                if(originalGraph[i][j] == 0) {
                    newWall.add(new int[]{i, j});
                }
            }
        }
        int[][] selected = new int[3][2];
        Combination(newWall, 0, 0, selected);
        System.out.println(max);

    }
}