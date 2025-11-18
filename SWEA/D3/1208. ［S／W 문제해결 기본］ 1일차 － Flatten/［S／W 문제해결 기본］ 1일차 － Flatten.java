
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
            int N = sc.nextInt();
            int[] arr = new int[100];
            for(int i=0; i<100; i++) {
                arr[i] = sc.nextInt();
            }
            for(int i=0; i<N; i++) {
                Arrays.sort(arr);
                arr[0]++;
                arr[99]--;
            }
            Arrays.sort(arr);
            int answer = arr[99] - arr[0];
            System.out.println("#" + test_case + " " + answer);
        }
    }
}