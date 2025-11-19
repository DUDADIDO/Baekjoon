
import java.util.Scanner;
import java.io.FileInputStream;


class Solution
{
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            int sum = 0;
            for(int i=0; i<10; i++) {
                sum += sc.nextInt();
            }
            double avg = sum / 10.0;
            int avgInt = sum / 10;
            if(avg - avgInt >= 0.5) {
                avgInt = avgInt + 1;
            }
            System.out.println("#" + test_case + " " + avgInt);

        }
    }
}