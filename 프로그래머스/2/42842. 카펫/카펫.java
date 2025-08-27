class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = {0, 0};
        int num = (brown - 4) / 2;
        for(int i=1; i<=num/2; i++) {
            int tmp = i * (num - i);
            if(tmp == yellow) {
                answer[0] = num-i+2;
                answer[1] = i+2;
            }
        }
        return answer;
    }
}