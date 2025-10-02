import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        List<Integer> list = new LinkedList<>();
        int[] one = {1, 2, 3, 4, 5};
        int[] two = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] three = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        
        int indexOne = 0;
        int indexTwo = 0;
        int indexThree = 0;
        
        int cntOne = 0;
        int cntTwo = 0;
        int cntThree = 0;
        
        for(int i=0; i<answers.length; i++) {
            int answer = answers[i];
            
            if(indexOne >= one.length)
                indexOne = 0;
            if(indexTwo >= two.length)
                indexTwo = 0;
            if(indexThree >= three.length)
                indexThree = 0;
            
            if(answer == one[indexOne])
                cntOne++;
            if(answer == two[indexTwo])
                cntTwo++;
            if(answer == three[indexThree])
                cntThree++;
            
            indexOne++;
            indexTwo++;
            indexThree++;
        }
        int max = Math.max(cntOne, Math.max(cntTwo, cntThree));
        if(cntOne == max)
            list.add(1);
        if(cntTwo == max)
            list.add(2);
        if(cntThree == max)
            list.add(3);
        
        Collections.sort(list);
        int[] answer = new int[list.size()];
        for(int i=0; i<list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
}