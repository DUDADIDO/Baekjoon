class Solution {
    public long solution(int price, int money, int count) {

        long tmp = 0;
         for(int i=1; i<=count; i++) {
             tmp += price * i;
         }
        if(money >= tmp)
            return 0;
        else
            return tmp - money;

    }
}