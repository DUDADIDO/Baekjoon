import java.io.*;
import java.util.*;

class Solution {
    public String solution(String s) {
        StringTokenizer st = new StringTokenizer(s);
        int count = 0;
        while(st.hasMoreTokens()) {
            st.nextToken();
            count++;
        }
        StringBuilder sb = new StringBuilder();
        int[] arr = new int[count];
        
        int i = 0;
        st = new StringTokenizer(s);
        while(st.hasMoreTokens()) {
            arr[i] = Integer.parseInt(st.nextToken());
            i++;
        }
        int min = Arrays.stream(arr).min().getAsInt();
        int max = Arrays.stream(arr).max().getAsInt();
        sb.append(min).append(" ").append(max);
        String answer = sb.toString();
        return answer;
    }
}