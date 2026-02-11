import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 채굴 범위는 마름모 (k가 중심으로부터 몇개 위로 삐져나갈지)
// k의 최대 크기는  (n/2)+1
// k의 범위는 0 <= k <= (n/2)+1
// 맵 밖으로 벗어난 채굴범위여도 상관 없음. 단 범위 체크는 잘 해야할 듯
public class Main {
    public static void main(String[] args) throws IOException {
    	int maxCnt = 0;
    	int maxCost = 0;
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	List<int[]> list = new ArrayList<>();
        int n = Integer.parseInt(st.nextToken()); // 격자의 크기
        int m = Integer.parseInt(st.nextToken()); // 금 한개의 가격
        int[][] grid = new int[n][n];
        for (int i = 0; i < n; i++) {
        	st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
            	grid[i][j] = Integer.parseInt(st.nextToken()); // 1이 금이 있는 위치.
            	if(grid[i][j] == 1) {
            		list.add(new int[] {i, j});
            	}
            }
        }
        for(int k=0; k<=(n/2)+1; k++) { // k의 크기를 정하고
        	for(int i=0; i<n; i++) {
        		for(int j=0; j<n; j++) {
        			int cost = (k*k + (int)Math.pow((k+1), 2)) * -1;
        			int cnt = 0;
        			for(int a=0; a<list.size(); a++) {
        				int length = Math.abs(list.get(a)[0] - i) + Math.abs(list.get(a)[1] - j);
        				if(length <= k) { // 마름모 안에 존재한다면
        					cost += m;
        					++cnt;
        				}
        			}
        			if(cnt > maxCnt) {
        				if(cost >= 0) {
        					maxCost = cost;
        					maxCnt = cnt;
        				}
        			}
        			else if(cnt == maxCnt) {
        				if(cost >= 0) {
        					maxCost = cost;
        				}
        			}
        		}
        	}
        	
        }
        System.out.println(maxCnt);
        
        
    }
}