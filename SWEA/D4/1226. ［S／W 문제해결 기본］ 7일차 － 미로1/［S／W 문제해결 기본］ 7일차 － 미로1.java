import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int[][] map;
    static int[][] visited;
    static int mapSize = 16;
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int tc=1; tc<=10; tc++) {
            br.readLine();
            map = new int[mapSize][mapSize];
            visited = new int[mapSize][mapSize];
            int[] start = new int[2];
            int[] goal = new int[2];
            for(int i=0; i<16; i++) {
                String input = br.readLine();
                for(int j=0; j<16; j++) {
                    map[i][j] = input.charAt(j)-'0';
                    if(map[i][j] == 2) {
                        start[0] = i;
                        start[1] = j;
                    }
                    if(map[i][j] == 3) {
                        goal[0] = i;
                        goal[1] = j;
                    }
                }
            }
            sb.append("#").append(tc).append(" ");
            bfs(start[0], start[1]);
            if(visited[goal[0]][goal[1]] > 0) {
                sb.append("1");
            }
            else {
                sb.append("0");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
    static void bfs(int startR, int startC) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{startR, startC});
        int cnt = 1;
        visited[startR][startC] = cnt;

        while(!q.isEmpty()) {
            cnt++;
            int qSize = q.size();
            for(int i=0; i<qSize; i++) {
                int[] cur = q.poll();
                int cR = cur[0];
                int cC = cur[1];
                for(int d=0; d<4; d++) {
                    int nr = cR + dr[d];
                    int nc = cC + dc[d];
                    if(nr<0 || nr>=mapSize || nc<0 || nc>=mapSize) continue;
                    if(visited[nr][nc]!=0 || map[nr][nc] == 1) continue;
                    visited[nr][nc] = cnt;
                    q.offer(new int[]{nr, nc});
                }
            }
        }
    }
}
