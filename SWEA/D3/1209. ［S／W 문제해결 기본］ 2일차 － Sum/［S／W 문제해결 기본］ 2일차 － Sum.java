
import java.util.Arrays;
import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);

        for(int test_case = 1; test_case <= 10; test_case++)
        {
            int T = sc.nextInt();

            int[][] arr = new int[100][100];
            for(int i=0; i<100; i++) {
                for(int j=0; j<100; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }
            int max = Integer.MIN_VALUE;
            for(int i=0; i<100; i++) {
                int sum = 0;
                int sum2 = 0;
                for (int j = 0; j < 100; j++) {
                    sum += arr[i][j];
                    sum2 += arr[j][i];
                }
                if (sum > sum2) {
                    if (sum > max) {
                        max = sum;
                    }
                } else {
                    if (sum2 > max) {
                        max = sum2;
                    }
                }
            }
            int sum = 0;
            for(int i=0; i<100; i++) {
                sum += arr[i][i];
            }
            if(sum > max)
                max = sum;
            sum = 0;
            for(int i=0; i<100; i++) {
                sum += arr[99-i][i];
            }
            if(sum > max)
                max = sum;

            System.out.println("#" + T + " " + max);
        }
    }
}