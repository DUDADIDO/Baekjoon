import java.util.Scanner;

public class Main {
    static int[] select, nums;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        int n = sc.nextInt();
        // Please write your code here.
        select = new int[n];
        nums = new int[k];
        for(int i=1; i<=k; i++) {
            nums[i-1] = i;
        }

        combi(0, k, n);
    }
    static void combi(int L, int k, int n) {
        if(L == n) {
            for(int num : select)
                sb.append(num).append(" ");
            sb.append("\n");
            return;
        }

        for(int i=0; i<k; i++) {
            select[L] = nums[i];
            combi(L+1, k, n);
        }

    }
}