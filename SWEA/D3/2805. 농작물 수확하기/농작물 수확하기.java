
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            int N = sc.nextInt();
            int[][] arr = new int[N][N];

            for(int i=0; i<N; i++) {
                String tmp = sc.next();
                String[] strs = tmp.split("");
                for(int j=0; j<N; j++) {
                    arr[i][j] = Integer.parseInt(strs[j]);
                }
            }
            int sum = 0;
            int mid = N/2;
            int Idx = 0;
            boolean flag = false;
            for(int i=0; i<N; i++) {
                sum += arr[i][mid];
                for(int j=1; j<=Idx; j++) {
                    sum += arr[i][mid+j];
                    sum += arr[i][mid-j];
                }
                if(Idx >= N/2) {
                    flag = true;
                }
                if(flag)
                    Idx--;
                else
                    Idx++;
            }
            System.out.println("#" + test_case + " " + sum);
        }
    }
}