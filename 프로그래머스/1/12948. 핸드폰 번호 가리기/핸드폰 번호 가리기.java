import java.util.*;

class Solution {
    public String solution(String phone_number) {
        StringBuilder sb = new StringBuilder();
        int n = phone_number.length();
        
        for(int i=0; i<n; i++) {
            if(i < n - 4) {
                sb.append("*");
            }
            else {
                sb.append(phone_number.charAt(i));
            }
        }
        
        return sb.toString();
    }
}