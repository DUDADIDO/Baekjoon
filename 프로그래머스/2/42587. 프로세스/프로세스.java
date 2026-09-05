import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        
        int targetIdx = location;
        Queue<int[]> q = new ArrayDeque<>();
        
        for(int i=0; i<priorities.length; i++) {
            q.offer(new int[]{priorities[i], i});
        }
        int cnt = 0;
        while(!q.isEmpty()) {
            int[] tmp = q.poll();
            int max = 0;
            for(int i=0; i<q.size(); i++) {
                int[] tmp2 = q.poll();
                if(tmp2[0] > max) max = tmp2[0];
                q.offer(tmp2);
            }
            if(max > tmp[0]) {
                q.offer(tmp);
            }
            else {
                cnt++;
                if(tmp[1] == location)
                    answer = cnt;
            }
                
            
        }
        
        return answer;
    }
}