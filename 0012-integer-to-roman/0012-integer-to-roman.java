import java.util.*;
import java.io.*;

class Solution {
    static StringBuilder sb = new StringBuilder();
    static int divideNum;
    static int[] nums = {1, 5, 10, 50, 100, 500, 1000};
    public String intToRoman(int num) {
        sb = new StringBuilder();
        String tmp = Integer.toString(num);
        int numLength = tmp.length();

        divideNum = (int)Math.pow(10.0, (double)numLength);
        while(num > 0) {
            int etc = num % divideNum;
            int curNum = (num / divideNum) * divideNum;
            
            if(curNum > 0) {
                System.out.println(curNum);
                solve(curNum);
            }
            num = num % divideNum;
            divideNum /= 10;
        }
        System.out.println(sb);
        return sb.toString();
    }
    static void solve(int num) {
        if(num/divideNum == 4) {
            int idx = 0;
            for(int i=0; i<nums.length; i++) {
                if(num < nums[i]) {
                    idx = i-1;
                    break;
                }
            }
            sb.append(getChar(nums[idx]));
            sb.append(getChar(nums[idx+1]));
        }
        else if(num/divideNum == 9) {
            int idx = 0;
            for(int i=0; i<nums.length; i++) {
                if(num < nums[i]) {
                    idx = i-1;
                    break;
                }
            }
            System.out.println("idx: " + idx + " idx+2: " + (idx+2));
            sb.append(getChar(nums[idx-1]));
            sb.append(getChar(nums[idx+1]));

        }
        else {
            
            int idx = 6;
            for(int i=0; i<nums.length; i++) {
                if(num < nums[i]) {
                    idx = i-1;
                    break;
                }
            }
            sb.append(getChar(nums[idx]));
            num = num - nums[idx];
            if(num > 0) solve(num);
        }
    }
    static char getChar(int num) {
        if(num == 1) return 'I';
        else if(num == 5) return 'V';
        else if(num == 10) return 'X';
        else if(num == 50) return 'L';
        else if(num == 100) return 'C';
        else if(num == 500) return 'D';
        else return 'M';
    }
}