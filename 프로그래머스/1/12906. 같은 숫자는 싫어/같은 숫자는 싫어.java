import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        int[] answer;
        int[] tmp = new int[arr.length];
        tmp[0] = arr[0];
        int index = 1;
        for(int i=1; i<arr.length; i++) {
            if(tmp[index-1] == arr[i]) {
                continue;
            }
            else {
                tmp[index] = arr[i];
                index++;
            }
        }
        answer = new int[index];
        for(int i=0; i<index; i++) {
            answer[i] = tmp[i];
        }

        return answer;
    }
}