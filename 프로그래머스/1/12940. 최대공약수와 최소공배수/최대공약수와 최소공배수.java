class Solution {
    public int gcd(int n, int m) {
        if(m == 0)
            return n;
        else
            return gcd(m, n%m);
    }
    public int[] solution(int n, int m) {
        int[] answer = new int[2];
        if(n < m) {
            int tmp = n;
            n = m;
            m = tmp;
        }
        int gcd = gcd(n, m);
        int lcm = (n * m) / gcd;
        
        answer[0] = gcd;
        answer[1] = lcm;
        
        
        return answer;
    }
}