
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
            int N, M;
            N = sc.nextInt();
            M = sc.nextInt();

            int max = Integer.MIN_VALUE;

            int[][] map = new int[N][N];
            for(int i=0; i<N; i++) {
                for(int j=0; j<N; j++) {
                    map[i][j] = sc.nextInt();
                }
            }
            for(int i=0; i<=N-M; i++) {
                for(int j=0; j<=N-M; j++) {
                    int tmpSum = 0;
                    for(int a=i; a<i+M; a++) {
                        for(int b=j; b<j+M; b++) {
                            tmpSum += map[a][b];
                        }
                    }
                    if(tmpSum > max)
                        max = tmpSum;

                }
            }

            System.out.println("#" + test_case + " " + max);
        }
    }
}