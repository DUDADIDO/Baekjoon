import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> list = new LinkedList<>();
        int releaseIndex = 0;
        
        while(true) {
            boolean flag = false;
            for(int i=0; i<progresses.length; i++) {
                if(progresses[i] < 100) {
                    flag = true;
                    break;
                }
            }
            if(!flag) { // 모든 작업이 100까지 완료 됨.
                break;
            }
            
            int releaseCnt = 0;
            if(progresses[releaseIndex] >= 100) {
                for(int i=releaseIndex; i<progresses.length; i++) {
                    if(progresses[i] >= 100) {
                        releaseCnt++;
                    }
                    else {
                        break;
                    }
                }
                list.add(releaseCnt);
                releaseIndex += releaseCnt;
            }

            for(int i=0; i<progresses.length; i++) {
                progresses[i] += speeds[i];
            }
            
        }
        if(releaseIndex < progresses.length) {
            list.add(progresses.length - releaseIndex);
        }
        
        int[] answer = new int[list.size()];
        for(int i=0; i<answer.length; i++) {
            answer[i] = list.get(i).intValue();
        }
        return answer;
    }
}