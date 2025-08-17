import java.io.*;
import java.util.*;

class Solution
{
    public int solution(int []A, int []B)
    {
        int answer = 0;
        Arrays.sort(A);
        Integer[] B2 = Arrays.stream(B).boxed().toArray(Integer[]::new);
        Arrays.sort(B2, Collections.reverseOrder());
        
        for(int i=0; i<A.length; i++) {
            answer += A[i] * B2[i];
        }

        return answer;
    }
}