import java.util.*;
import java.io.*;

class Solution {
    public int solution(int n) {
        int answer = 0;
        Queue<Integer> q = new LinkedList<>();
        int sum = 0;
        for(int i=1; i<=n; i++) {
            q.add(i);
            sum += i;
            if(sum == n) {
                answer++;
            }
            else if(sum > n) {
                while(sum > n) {
                    sum -= q.remove();
                }
                if(sum == n) {
                    answer++;
                }
            }

        }
        
        return answer;
    }
}