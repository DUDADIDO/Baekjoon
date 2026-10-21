import java.util.*;

class Solution {
    static boolean[][] visited;
    static int[][] map;
    static int rSize, cSize;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    
    public int[] solution(String[] maps) {
        List<Integer> answer = new ArrayList<>();
        rSize = maps.length;
        cSize = maps[0].length();
        
        map = new int[rSize][cSize];
        visited = new boolean[rSize][cSize];

        for(int i=0; i<rSize; i++) {
            for(int j=0; j<cSize; j++) {
                if(maps[i].charAt(j) == 'X') map[i][j] = 0;
                else map[i][j] = maps[i].charAt(j) - '0'; 
            }
            
        }
        
        // for(int i=0; i<length; i++) {
        //     for(int j=0; j<length; j++) {
        //         System.out.print(map[i][j] + " ");
        //     }
        //     System.out.println();
        // }
        
        for(int i=0; i<rSize; i++) {
            for(int j=0; j<cSize; j++) {
                if(visited[i][j] == false && map[i][j] > 0) {
                    int result = bfs(i, j);
                    answer.add(result);
                    // System.out.println("ㄴㅇㅅ");
                }
            }
        }
        if(answer.size() == 0) return new int[]{-1};
        int[] tmp = new int[answer.size()];
        for(int i=0; i<tmp.length; i++) {
            tmp[i] = answer.get(i);
        }
        Arrays.sort(tmp);
        return tmp;
    }
    public int bfs(int r, int c) {
        int result = 0;
        result += map[r][c];
        visited[r][c] = true;
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{r, c}) ;
        
        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            
            int cr = cur[0];
            int cc = cur[1];
            
            for(int i=0; i<4; i++) {
                int nr = cr + dr[i];
                int nc = cc + dc[i];
                
                if(nr < 0 || nr >= rSize || nc < 0 || nc >= cSize) continue;
                if(map[nr][nc] == 0 || visited[nr][nc]) continue;
                visited[nr][nc] = true;
                result += map[nr][nc];
                queue.offer(new int[]{nr, nc});
            }
        }
        return result;
    }
}