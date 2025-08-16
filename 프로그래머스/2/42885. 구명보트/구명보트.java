import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);
        int leftIdx = 0;
        int rightIdx = people.length - 1;
        while(leftIdx <= rightIdx) {
            if(people[leftIdx] + people[rightIdx] <= limit) {
                answer++;
                leftIdx++;
                rightIdx--;
            }
            else {
                answer++;
                rightIdx--;
            }
        }
        
        return answer;
    }
}