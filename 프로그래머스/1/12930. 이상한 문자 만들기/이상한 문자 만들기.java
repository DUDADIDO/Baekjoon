import java.util.*;

class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        int counter = 0;
        for(int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);
            if(ch == ' ') {
                sb.append(" ");
                counter = 0;
                continue;
            }
            if(counter % 2 == 0) {
                sb.append(Character.toUpperCase(ch)); 
            }
            else {
                sb.append(Character.toLowerCase(ch)); 
            }
            counter++;
        }
        
        
        return sb.toString();
    }
}