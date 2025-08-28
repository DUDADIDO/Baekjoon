class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        int left = 0;
        int right = 9;
        while(right < discount.length) {
            boolean flag = true;
            for(int i=0; i<want.length; i++) {
                int cnt = 0;
                for(int j=left; j<=right; j++) {
                    if(want[i].equals(discount[j])) {
                        cnt++;
                    }
                }
                if(cnt != number[i]) {
                    flag = false;
                    break;
                }
            }
            if(flag) {
                ++answer;
            }
            left++;
            right++;
        }
        return answer;
    }
}