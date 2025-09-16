class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0;
        
        while(n >= a) {
            int bottle = n / a;
            bottle *= b;
            int remainBottle = n % a;
            n = bottle + remainBottle;
            answer += bottle;
        }
        
        return answer;
    }
}