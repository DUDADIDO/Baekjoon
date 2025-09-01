import java.util.*;
import java.io.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        
        Queue<Character> q = new LinkedList<>();
        for(int i=0; i<s.length(); i++) {
            q.add(s.charAt(i));
        }
        for(int i=0; i<s.length(); i++) {
            char[] tmp = new char[q.size()];
            boolean flag = false;
            int index = 0;
            for (char c : q) {
                tmp[index++] = c;
            }
            Stack<Character> charStack = new Stack<>();
            for(int j=0; j<tmp.length; j++) {
                switch(tmp[j]) {
                    case '[':
                        charStack.push('[');
                        break;
                    case ']':
                        if(charStack.isEmpty() || charStack.peek() != '[') {
                            flag = true;
                            break;
                        }
                        charStack.pop();
                        break;
                    case '{':
                        charStack.push('{');
                        break;
                    case '}':
                        if(charStack.isEmpty() || charStack.peek() != '{') {
                            flag = true;
                            break;
                        }
                        charStack.pop();
                        break;
                    case '(':
                        charStack.push('(');
                        break;
                    case ')':
                        if(charStack.isEmpty() || charStack.peek() != '(') {
                            flag = true;
                            break;
                        }
                        charStack.pop();
                        break;
                }
            }
            if(charStack.isEmpty() && !flag) {
                answer++;
            }
            q.add(q.remove());
            
        }
        return answer;
    }
}