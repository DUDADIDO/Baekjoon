import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        
        int[] big = new int[10001];
        int[] little = new int[10001];
        int bigCnt = 0;
        int littleCnt = 0;
        int size = topping.length;
        
        for(int i=0; i<size; i++) {
            little[topping[i]]++;
            if(little[topping[i]] == 1)
                littleCnt++;
        }
        for(int i=0; i<size; i++) {
            big[topping[i]]++;
            if(big[topping[i]] == 1)
                bigCnt++;
            little[topping[i]]--;
            if(little[topping[i]] == 0)
                littleCnt--;
            
            if(bigCnt == littleCnt)
                answer++;
        }
        
        
        return answer;
    }
}