
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.io.FileInputStream;

class co {
    public int x;
    public int y;

    public co(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
class Solution
{



    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            int[] moveX = {1, 0, -1, 0};
            int[] moveY = {0, 1, 0, -1};
            int moveIdx = 0;
            int N = sc.nextInt();
            int[][] graph = new int[N][N];

            int nextX = 0;
            int nextY = 0;
            for(int i=1; i<=N*N; i++) {
                graph[nextX][nextY] = i;
                int curX = nextX;
                int curY = nextY;

                nextX = curX + moveX[moveIdx];
                nextY = curY + moveY[moveIdx];

                if(nextX < 0 || nextX >= N || nextY < 0 || nextY >= N || graph[nextX][nextY] != 0) {
                    moveIdx++;
                    if(moveIdx >= 4)
                        moveIdx %= 4;
                    nextX = curX + moveX[moveIdx];
                    nextY = curY + moveY[moveIdx];
                }

            }
            System.out.println("#" + test_case);
            for(int i=0; i<N; i++) {
                for(int j=0; j<N; j++) {
                    System.out.print(graph[j][i] + " ");
                }
                System.out.println();
            }



        }
    }
}