import java.io.*;
import java.util.*;

class Solution {
    public class Gyul {
        public int size;
        public int count;
        
        public Gyul(int size, int count) {
            this.size = size;
            this.count = count;
        }
    }
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        
        Map<Integer, Integer> map = new HashMap<>();
        for(int size : tangerine) {
            map.put(size, map.getOrDefault(size, 0) + 1);
        }
        
        PriorityQueue<Gyul> pq = new PriorityQueue<>((g1, g2) -> g2.count - g1.count);
        
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            pq.add(new Gyul(entry.getKey(), entry.getValue()));
        }
        
        while(k > 0) {
            Gyul cur = pq.poll();
            k -= cur.count;
            answer++;
        }
        
        return answer;
    }
}