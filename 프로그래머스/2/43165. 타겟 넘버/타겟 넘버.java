import java.util.*;

class Solution {
    static int answer;
    public int solution(int[] numbers, int target) {
        answer = 0;
        dfs(numbers, target, 0, 0);
        
        return answer;
    }
    public void dfs(int[] numbers, int target, int L, int sum) {
        if(L == numbers.length) {
            if(sum == target) {
                answer++;
            }
            return;
        }
        dfs(numbers, target, L+1, sum + numbers[L]);

        dfs(numbers, target, L+1, sum - numbers[L]);
    }
}

