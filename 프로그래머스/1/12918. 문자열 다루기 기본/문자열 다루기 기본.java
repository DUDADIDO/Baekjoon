class Solution {
    public boolean solution(String s) {
        boolean answer = true;
        if(s.length() == 4 || s.length() == 6) {
            for(int i=0; i<s.length(); i++) {
                char tmp = s.charAt(i);
                if(tmp < '0' || tmp > '9') {
                    answer = false;
                    break;
                }
            }
        }
        else
            answer = false;
        return answer;
    }
}