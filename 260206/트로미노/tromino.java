import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        int max = -1;
        // Please write your code here.
        for(int i=0; i<n; i++) {
            for(int j=0; j<m-2; j++) {
                int sum = arr[i][j] + arr[i][j+1] + arr[i][j+2];
                max = Math.max(sum, max);
            }
        }
        for(int i=0; i<n-2; i++) {
            for(int j=0; j<m; j++) {
                int sum = arr[i][j] + arr[i+1][j] + arr[i+2][j];
                max = Math.max(sum, max);
            }
        }


        for(int i=0; i<n-1; i++) { // 1
            for(int j=0; j<m-1; j++) {
                int sum = arr[i][j] + arr[i+1][j] + arr[i+1][j+1];
                max = Math.max(sum, max);
            }
        }
        for(int i=0; i<n-1; i++) { // 4
            for(int j=0; j<m-1; j++) {
                int sum = arr[i+1][j+1] + arr[i+1][j] + arr[i][j+1];
                max = Math.max(sum, max);
            }
        }
        for(int i=0; i<n-1; i++) { // 3
            for(int j=0; j<m-1; j++) {
                int sum = arr[i][j] + arr[i][j+1] + arr[i+1][j+1];
                max = Math.max(sum, max);
            }
        }
        for(int i=0; i<n-1; i++) { // 2
            for(int j=0; j<m-1; j++) {
                int sum = arr[i][j] + arr[i+1][j] + arr[i][j+1];
                max = Math.max(sum, max);
            }
        }
        System.out.println(max);
    }
}