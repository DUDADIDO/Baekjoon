import java.io.*;
import java.util.*;

class Solution {
    public String solution(int[] food) {
        String answer = "";
        int[] repeat = new int[food.length-1]; // 반복 횟수를 저장 할 배열
        StringBuilder sb = new StringBuilder();
        for(int i=1; i<food.length; i++) {
            repeat[i-1] = food[i] / 2; // 반복 횟수는 나누기 2회 한다
        }
        for(int i=0; i<repeat.length; i++) {
            for(int j=0; j<repeat[i]; j++) {
                answer += Integer.toString(i+1); // Integer.toString을 이용해 정수를 문자열 자료형으로 변환한다.
            }
        }
        answer += Integer.toString(0); // 중간에 물을 마신다. 물은 1회 마신다는 고정 조건이 있었으므로 직접 1회 추가해준다.
        for(int i=repeat.length-1; i>=0; i--) {
            for(int j=0; j<repeat[i]; j++) {
                answer += Integer.toString(i+1); // Integer.toString을 이용해 정수를 문자열 자료형으로 변환한다.
            }
        }
        return answer;
    }
}