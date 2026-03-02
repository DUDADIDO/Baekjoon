import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int rSize, cSize;
    static char[][] map;
    static boolean[][] visited;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int tc=1; tc<=T; tc++) {
            st = new StringTokenizer(br.readLine());
            rSize = Integer.parseInt(st.nextToken());
            cSize = Integer.parseInt(st.nextToken());

            map = new char[rSize][cSize];
            visited = new boolean[rSize][cSize];

            for(int i=0; i<rSize; i++) {
                map[i] = br.readLine().toCharArray();
            }
            int answer = 0;
            for(int i=0; i<rSize; i++) {
                for(int j=0; j<cSize; j++) {
                    if(!visited[i][j] && map[i][j] == '#') {
                        bfs(i, j);
                        ++answer;
                    }
                }
            }
            sb.append(answer).append("\n");
        }
        System.out.println(sb);
    }
    static void bfs(int r, int c) {
        Queue<int[]> q = new LinkedList<>();
        visited[r][c] = true;
        q.offer(new int[]{r, c});

        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int cr = cur[0];
            int cc = cur[1];
            for(int i=0; i<4; i++) {
                int nr = cr + dr[i];
                int nc = cc + dc[i];

                if(nr<0 || nr>=rSize || nc<0 || nc>=cSize) continue;
                if(visited[nr][nc] || map[nr][nc] != '#') continue;

                visited[nr][nc] = true;
                q.offer(new int[]{nr, nc});
            }
        }

    }
}
