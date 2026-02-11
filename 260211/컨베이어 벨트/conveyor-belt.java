import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int t = sc.nextInt();
        int[] top = new int[n];
        int[] bottom = new int[n];
        for (int i = 0; i < n; i++) {
            top[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            bottom[i] = sc.nextInt();
        }
        for(int timer=0; timer<t; timer++) {
            int topTmp = top[n-1];
            int bottomTmp = bottom[n-1];
            for(int i=n-1; i>0; i--) {
                top[i] = top[i-1];
                bottom[i] = bottom[i-1];
            }
            top[0] = bottomTmp;
            bottom[0] = topTmp;
        }
        for(int num : top) {
            System.out.print(num + " ");
        }
        System.out.println();
        for(int num : bottom) {
            System.out.print(num + " ");
        }
        // Please write your code here.
    }
}