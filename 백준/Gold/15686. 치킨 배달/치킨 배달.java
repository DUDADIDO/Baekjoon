import java.util.Scanner;

public class Main {
    static class Coor {
        int r, c;
        Coor(int r, int c) {
            this.r = r;
            this.c = c;

        }
    }
    static int min = Integer.MAX_VALUE;
    static int n;
    static int m;
    static int[][] map;
    static boolean[] visited;
    static int[] selected;
    static int chickenCnt;
    static int homeCnt;

    static Coor[] stores;
    static Coor[] homes;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        map = new int[n][n];
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                int input = sc.nextInt();

                map[i][j] = input;
                if(input == 1)
                    homeCnt++;

                else if(input == 2) chickenCnt++;
            }
        }
        homes = new Coor[homeCnt];
        stores = new Coor[chickenCnt];
        selected = new int[m];
        int homeIdx = 0;
        int storesIdx = 0;
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(map[i][j] == 1) {
                    homes[homeIdx] = new Coor(i, j);
                    homeIdx++;
                }
                else if(map[i][j] == 2) {
                    stores[storesIdx] = new Coor(i, j);
                    storesIdx++;
                }
            }
        }
        dfs(0, 0);
        System.out.println(min);

    }

    static void dfs(int L, int start) {
        if(L == m) {
            int result = 0;
            for(int i=0; i<homeCnt; i++) {
                Coor curHome = homes[i];
                int minHomeDist = Integer.MAX_VALUE;
                for(int j=0; j<m; j++) {
                    Coor curStore = stores[selected[j]];
                    int distance = Math.abs(curStore.r-curHome.r) + Math.abs(curStore.c - curHome.c);
                    minHomeDist = Math.min(distance, minHomeDist);
                }
                result += minHomeDist;
            }

            min = Math.min(result, min);
            return;
        }

        for(int i=start; i<chickenCnt; i++) {

            selected[L] = i;
            dfs(L+1, i+1);
        }


    }
}
