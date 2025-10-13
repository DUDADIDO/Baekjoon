import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        
        ArrayList<Integer> list = new ArrayList<>();
        Arrays.sort(numbers);
        int max = numbers[numbers.length-1] + numbers[numbers.length-2];
        boolean[] check = new boolean[max + 1];
        for(int i=0; i<numbers.length - 1; i++) {
            for(int j=i+1; j<numbers.length; j++) {
                int tmp = numbers[i] + numbers[j];
                check[tmp] = true;
            }
        }
        for(int i=0; i<check.length; i++) {
            if(check[i])
                list.add(i);
        }
        int[] answer = new int[list.size()];
        for(int i=0; i<list.size(); i++) {
            answer[i] = list.get(i).intValue();
        }
        return answer;
    }
}