import java.util.*;

public class Main {
    static char[][] arr;
    static int answer = 0;
    public static void brutefForce(int n) {
        for(int i=0; i<n; i++) {
            int cnt = 1;
            for(int j=1; j<n; j++) {
                if(arr[i][j] == arr[i][j-1]) {
                    cnt++;
                }
                else {
                    cnt = 1;
                }
                answer = Math.max(answer, cnt);
            }

        }
        for(int i=0; i<n; i++) {
            int cnt = 1;
            for(int j=1; j<n; j++) {
                if(arr[j][i] == arr[j-1][i]) {
                    cnt++;
                }
                else {
                    cnt = 1;
                }
                answer = Math.max(answer, cnt);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        arr = new char[n][n];

        for(int i=0; i<n; i++) {
            String line = sc.nextLine();
            for(int j=0; j<n; j++) {
                arr[i][j] = line.charAt(j);
            }
        }

        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(j < n-1 && arr[i][j] != arr[i][j+1]) {
                    char tmp = arr[i][j];
                    arr[i][j] = arr[i][j+1];
                    arr[i][j+1] = tmp;
                    brutefForce(n);
                    tmp = arr[i][j];
                    arr[i][j] = arr[i][j+1];
                    arr[i][j+1] = tmp;
                }
                if(i < n-1 && arr[i][j] != arr[i+1][j]) {
                    char tmp = arr[i][j];
                    arr[i][j] = arr[i+1][j];
                    arr[i+1][j] = tmp;
                    brutefForce(n);
                    tmp = arr[i][j];
                    arr[i][j] = arr[i+1][j];
                    arr[i+1][j] = tmp;
                }
            }

        }
        System.out.println(answer);
    }
}