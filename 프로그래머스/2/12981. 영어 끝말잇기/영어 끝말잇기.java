import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(int n, String[] words) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put(words[0], 1);
        int[] answer = new int[2];
        int cnt = 1;
        for(int i=1; i<words.length; i++) {
            ++cnt;
            if(cnt > n)
                cnt %= n;
            int turn = i / n + 1;
            if(words[i-1].charAt(words[i-1].length()-1) != words[i].charAt(0)) { // 끝말읽기가 안된다면 break
                answer[0] = cnt;
                answer[1] = turn;
                break;
            }
            else {
                int tmp = map.getOrDefault(words[i], -1); 
                if(tmp == -1) { // default값인 -1이 나왔다면 앞서 나오지 않았던 단어.
                    map.put(words[i], 1);
                }
                else { // -1이외 다른게 나왔다면 앞서 나왔던 단어이므로 break;
                    answer[0] = cnt;
                    answer[1] = turn;
                    break;
                }
            }
        }
        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다. 
        System.out.println("Hello Java");

        return answer;
    }
}