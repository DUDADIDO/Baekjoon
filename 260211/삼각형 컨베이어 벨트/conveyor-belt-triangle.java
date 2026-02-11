import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int t = sc.nextInt();
        int[] l = new int[n];
        int[] r = new int[n];
        int[] d = new int[n];
        for (int i = 0; i < n; i++) {
            l[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            r[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            d[i] = sc.nextInt();
        }

         for(int timer=0; timer<t; timer++) {
            int lTmp = l[n-1];
            int rTmp = r[n-1];
            int dTmp = d[n-1];
            for(int i=n-1; i>0; i--) {
                l[i] = l[i-1];
                r[i] = r[i-1];
                d[i] = d[i-1];
            }
            l[0] = dTmp;
            r[0] = lTmp;
            d[0] = rTmp;
        }
        for(int num : l) {
            System.out.print(num + " ");
        }
        System.out.println();
        for(int num : r) {
            System.out.print(num + " ");
        }
        System.out.println();
        for(int num : d) {
            System.out.print(num + " ");
        }
        // Please write your code here.
    }
}