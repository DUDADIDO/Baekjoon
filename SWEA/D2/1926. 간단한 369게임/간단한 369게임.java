
import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        for(int i=1; i<=N; i++) {
            if(i <= 10) {
                if(i%3 == 0)
                    System.out.print("-");
                else
                    System.out.print(i);
            }
            else if(i <= 100) {
                boolean flag = false;
                if(i%10%3 == 0 && i%10 != 0) {
                    System.out.print("-");
                    flag = true;
                }
                if(i/10%3 == 0 && i/10 != 0) {
                    flag = true;
                    System.out.print("-");
                }
                if(!flag)
                    System.out.print(i);
            }
            else {
                boolean flag = false;
                if(i%10%3 == 0 && i%10 != 0) {
                    System.out.print("-");
                    flag = true;
                }
                if(i/10%10%3 == 0 && i/10%10 != 0) {
                    flag = true;
                    System.out.print("-");
                }
                if(i/100%3 == 0 && i/100 != 0) {
                    flag = true;
                    System.out.print("-");
                }
                if(!flag)
                    System.out.print(i);
            }
            System.out.print(" ");
        }

    }
}