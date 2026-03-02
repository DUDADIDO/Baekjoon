import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] map;
    static int[] percent;
    static boolean[][] visited;
    static int[] dr = {0, 0, 1, -1};
    static int[] dc = {1, -1, 0, 0};
    static int n;
    static double sum;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sum = 0.0;
        map = new int[30][30];
        visited = new boolean[30][30];
        n =Integer.parseInt(st.nextToken());
        percent = new int[4];
        for(int i=0; i<4; i++) {
            percent[i] = Integer.parseInt(st.nextToken());

        }
        visited[15][15] = true;
        dfs(0, 1.0, 15, 15);
        System.out.println(sum);
    }
    static void dfs(int L, double perc, int r, int c) {
        if(L == n) {
            sum += perc;
            return;
        }

        for(int i=0; i<4; i++) {
            if(percent[i] > 0) {
                int nr = r + dr[i];
                int nc = c + dc[i];
                if(visited[nr][nc]) continue;

                visited[nr][nc] = true;
                dfs(L+1, perc * percent[i] / 100.0, nr, nc);
                visited[nr][nc] = false;
            }
        }
    }
}
