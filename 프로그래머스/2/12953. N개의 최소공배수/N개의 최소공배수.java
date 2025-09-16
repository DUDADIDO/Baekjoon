class Solution {
    public int LCD(int a, int b) {
        if(b == 0) {
            return a;
        }
        else {
            return LCD(b, a % b);
        }
    }
    public int solution(int[] arr) {
        int answer = 0;
        if(arr.length == 1) {
            answer = arr[0];
        }
        else {
            int num = 1;
            for(int i=0; i<arr.length; i++) {
                num = (arr[i] * num) / LCD(num, arr[i]);
            }
            answer = num;
        }
        return answer;
    }
}