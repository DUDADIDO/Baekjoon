import java.io.*;
import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        String[] words = s.split(" ");
        char lastChar = s.charAt(s.length()-1);
        
        for(int i=0; i<words.length; i++) {
            for(int j=0; j<words[i].length(); j++) {
                char tmp = words[i].charAt(j);
                if(j == 0) {
                    tmp = Character.toUpperCase(tmp);
                }
                else {
                    tmp = Character.toLowerCase(tmp);
                }
                answer += tmp;
            }
            answer += " ";
        }
        if(lastChar == ' ') {
            return answer;
        }
        else {
            return answer.trim();
        }
    }
}