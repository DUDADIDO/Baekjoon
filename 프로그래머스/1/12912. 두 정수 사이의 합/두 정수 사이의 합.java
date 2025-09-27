class Solution {
    public long solution(int a, int b) {
        long answer = 0;
        int big;
        int small;
        if(a > b) {
            big = a;
            small = b;
        }
        else {
            big = b;
            small = a;
        }
        for(int i = small; i<=big; i++) {
            answer += i;
        }
        return answer;
    }
}