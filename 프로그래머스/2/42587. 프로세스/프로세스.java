import java.io.*;
import java.util.*;

class Solution {
    public class process {
        public int priority;
        public int flag;
        
        public process(int priority, int flag) {
            this.priority = priority;
            this.flag = flag;
        }
    }
    public int solution(int[] priorities, int location) {
        int answer = 0;
        
        int target = priorities[location];
        Queue<process> q = new LinkedList<>();
        
        Integer[] tmp = Arrays.stream(priorities).boxed().toArray(Integer[]::new);
        Arrays.sort(tmp, Collections.reverseOrder());
        
        int index = 0;
        for(int priority : priorities) {
            if(index == location) {
                q.add(new process(priority, 1));
            }
            else {
                q.add(new process(priority, 0));
            }
            index++;
        }
        for(int i=0; i<tmp.length; i++) {
            int cur = tmp[i];
            if(cur > target) {
                while(q.peek().priority != cur) {
                    q.add(q.remove());
                }
                q.remove();
                answer++;
                
                
                // if(q.peek().priority == cur) {
                //     q.remove();
                //     answer++;
                // }
                // else {
                //     q.add(q.remove());
                // }
            }
            else if(cur == target) {
                while(true) {
                   if(q.peek().priority == target) {
                       if(q.peek().flag == 1) {
                           answer++;
                           return answer;
                       }
                       else {
                           q.remove();
                           answer++;
                       }
                   }
                    else {
                        q.add(q.remove());
                    }
                }
                
                
                // if(q.peek().priority == target) {
                //     if(q.peek().flag == 1) {
                //         answer++;
                //         return answer;
                //     }
                //     else {
                //         q.add(q.remove());
                //     }
                // }
            }
        }
        return answer;
    }
}