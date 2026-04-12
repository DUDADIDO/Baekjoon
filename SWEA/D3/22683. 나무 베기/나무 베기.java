import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    static int n, k;
    static char[][] map;
    static boolean[][][][] visited;
    static class State {
        int r, c, dir, k, time;

        public State(int r, int c, int dir, int k, int time) {
            this.r = r;
            this.c = c;
            this.dir = dir;
            this.k = k;
            this.time = time;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int tc=1; tc<=T; tc++) {
            sb.append("#").append(tc).append(" ");
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            map = new char[n][n];
            visited = new boolean[n][n][4][k+1];
            for(int i=0; i<n; i++) {
                map[i] = br.readLine().toCharArray();
            }

            int sR, sC, gR, gC;
            sR = sC = gR = gC = 0;
            for(int i=0; i<n; i++) {
                for(int j=0; j<n; j++) {
                    if(map[i][j] == 'X') {
                        sR = i;
                        sC = j;
                    }
                    if(map[i][j] == 'Y') {
                        gR = i;
                        gC = j;
                    }
                }
            }
            int result = bfs(sR, sC, gR, gC);
            sb.append(result).append("\n");
        }
        System.out.println(sb);
    }
    static int bfs(int sR, int sC, int gR, int gC) {
        Queue<State> queue = new LinkedList<>();

        visited[sR][sC][0][0] = true;
        queue.offer(new State(sR, sC, 0, 0, 0));

        while(!queue.isEmpty()) {
            State cur = queue.poll();

            if(cur.r == gR && cur.c == gC)
                return cur.time;

            int nr = cur.r + dr[cur.dir];
            int nc = cur.c + dc[cur.dir];

            if(nr>=0 && nr<n && nc>=0 && nc<n) {
                if(map[nr][nc] != 'T') {
                    if(!visited[nr][nc][cur.dir][cur.k]) {
                        visited[nr][nc][cur.dir][cur.k] = true;
                        queue.offer(new State(nr, nc, cur.dir, cur.k, cur.time+1));
                    }

                }
                else if(cur.k < k) {
                    if(!visited[nr][nc][cur.dir][cur.k+1]) {
                        visited[nr][nc][cur.dir][cur.k+1] = true;
                        queue.offer(new State(nr, nc, cur.dir, cur.k+1, cur.time+1));
                    }

                }
            }


            int ndR = (cur.dir+1) % 4;
            if(!visited[cur.r][cur.c][ndR][cur.k]) {
                visited[cur.r][cur.c][ndR][cur.k] = true;
                queue.offer(new State(cur.r, cur.c, ndR, cur.k, cur.time+1));
            }
            int ndL = (cur.dir+3) % 4;
            if(!visited[cur.r][cur.c][ndL][cur.k]) {
                visited[cur.r][cur.c][ndL][cur.k] = true;
                queue.offer(new State(cur.r, cur.c, ndL, cur.k, cur.time+1));
            }
        }
        return -1;

    }
}
