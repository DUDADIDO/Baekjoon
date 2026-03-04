import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static int[][] grid;
	static boolean[][] visited;
	static int n, count;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int villageCnt = 0;
        n = sc.nextInt();
        grid = new int[n][n];
        visited = new boolean[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<n; i++) {
        	for(int j=0; j<n; j++) {
        		if(grid[i][j] == 1 && !visited[i][j]) {
        			count = 0;
        			dfs(i, j);
        			list.add(count);
        			villageCnt++;
        		}
        	}
        }
        Collections.sort(list);
        System.out.println(villageCnt);
        for(int num : list) {
        	System.out.println(num);
        }
        // Please write your code here.
    }
    
    static void dfs(int r, int c) {
    	count++;
    	visited[r][c] = true;
    	for(int d=0; d<4; d++) {
    		int nr = r + dr[d];
    		int nc = c + dc[d];
    		if(nr<0 || nr>=n || nc<0 || nc>=n) continue;
    		if(visited[nr][nc] || grid[nr][nc] == 0) continue;
    		
    		visited[nr][nc] = true;
    		dfs(nr, nc);
    	}
    	
    	
    	
    }
}