import java.io.*;
import java.util.*;

class Solution {
    public int solution(int n) {
        int answer = 0;
        String nString = Integer.toBinaryString(n);
        int oneCount = 0;
        for(int i=0; i<nString.length(); i++) {
            if(nString.charAt(i) == '1')
                ++oneCount;
        }
        int cur = n+1;
        while(true) {
            String curString = Integer.toBinaryString(cur);
            int curOneCount = 0;
            for(int i=0; i<curString.length(); i++) {
                if(curString.charAt(i) == '1') {
                    ++curOneCount;
                }
            }
            if(curOneCount == oneCount) {
                answer = cur;
                break;
            }
            else {
                ++cur;
            }
        }
        return answer;
    }
}