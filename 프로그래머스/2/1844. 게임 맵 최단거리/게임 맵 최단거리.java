import java.util.*;
class Solution {
    static int[][] visited;
    int[] dr = {-1, 1, 0, 0};
    int[] dc = {0, 0, -1, 1};
    public int solution(int[][] map) {
        int m = map.length;
        int n = map[0].length;
        int answer = 0;
        visited = new int[m][n];
        
        bfs(map, 0, 0, m, n);
        
        answer = visited[m-1][n-1];
        if(answer == 0) answer = -1;    
    
        return answer;
    }
    
    public void bfs(int[][] map, int r, int c, int m, int n) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{r, c});
        visited[r][c] = 1;
        
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int cr = cur[0];
            int cc = cur[1];
            for(int i=0; i<4; i++) {
                int nr = cr + dr[i];
                int nc = cc + dc[i];

                if(nr < 0 || nr >= m || nc < 0 || nc >= n) continue;
                if(map[nr][nc] == 0 || visited[nr][nc] != 0) continue;

                visited[nr][nc] = visited[cr][cc] + 1;
                q.offer(new int[]{nr, nc});
            }
        }
        
    }
}