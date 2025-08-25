import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(String s) {
        int[] answer = {0, 0};
        
        while(s.length() != 1) {
            StringBuilder sb = new StringBuilder();
            
            int cnt = 0; // 1의 개수를 셀 cnt변수
            for(int i=0; i<s.length(); i++) {
                if(s.charAt(i) == '1') { // 현재 자리수가 1이라면
                    cnt++;
                }
                else { // 현재 자리수가 0이라면 제거하면서 cnt증가
                    answer[1] = answer[1] + 1;
                }
            }

            s = Integer.toBinaryString(cnt);
            
            answer[0]++;
            
        }
        
        return answer;
    }
}