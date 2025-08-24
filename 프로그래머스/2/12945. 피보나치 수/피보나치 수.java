class Solution {
    public int solution(int n) {
        int answer = 0;
        
        int[] fib = new int[100001];
        fib[0] = 0;
        fib[1] = 1;
        for(int i=2; i<=n; i++) {
            fib[i] = fib[i-2] + fib[i-1];
            if(fib[i] >= 1234567) {
                fib[i] = fib[i] % 1234567;
            }
        }
        answer = fib[n];
        return answer;
    }
}