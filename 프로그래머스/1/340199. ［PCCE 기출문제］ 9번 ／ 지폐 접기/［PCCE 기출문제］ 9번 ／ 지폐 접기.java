import java.util.*;

class Solution {
    public int solution(int[] wallet, int[] bill) {
        Scanner sc = new Scanner(System.in);
        int answer = 0;
        int wMax, wMin, bMax, bMin;
        wMax = Math.max(wallet[0], wallet[1]);
        wMin = Math.min(wallet[0], wallet[1]);
        
        while(true) {
            bMax = Math.max(bill[0], bill[1]);
            bMin = Math.min(bill[0], bill[1]);
            if(bMax <= wMax && bMin <= wMin)
                break;
            
            if(bill[0] > bill[1]) {
                bill[0] /= 2;
            }
            else {
                bill[1] /= 2;
            }
            answer++;
        }
        return answer;
    }
}