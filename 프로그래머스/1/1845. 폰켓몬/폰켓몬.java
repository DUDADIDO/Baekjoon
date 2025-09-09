import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++) {
            map.put(nums[i], map.getOrDefault(0, i) + 1);
        }
        int size = map.size();
        int target = nums.length / 2;
        if(size > target) {
            answer = target;
        }
        else {
            answer = size;
        }
        return answer;
    }
}