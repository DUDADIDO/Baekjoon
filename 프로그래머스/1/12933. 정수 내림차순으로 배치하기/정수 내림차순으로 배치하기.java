import java.util.*;

class Solution {
    public long solution(long n) {
        long answer = 0;
        List<Integer> list = new LinkedList<>();
        while(n > 0) {
            list.add((int)(n % 10));
            n /= 10;
        }
        list.sort(Comparator.reverseOrder());
        
        for(int num : list) {
            answer = answer * 10 + num;
        }
        
        return answer;
    }
}