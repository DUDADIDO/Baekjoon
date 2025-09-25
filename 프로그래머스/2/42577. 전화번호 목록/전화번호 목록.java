import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        
        Set<String> set = Arrays.stream(phone_book).collect(Collectors.toSet()); // 주어진 번호들을 set으로 저장
        for(String phoneNum : set) { // set안에 있는 번호들 각각에 대해 반복
            for(int i=1; i<phoneNum.length(); i++) { // 번호들을 인덱스0 부터 i까지 쪼개서 이 쪼개진 문자열이 set안에 있는지 검사.
                if(set.contains(phoneNum.substring(0, i))) { // 쪼개진 문자열이 set안에 존재 한다면 접두어가 존재한다는 의미.
                    return false; // false반환
                }
            }
        }
        return answer;
    }
}