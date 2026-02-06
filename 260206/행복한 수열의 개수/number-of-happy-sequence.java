import java.util.Scanner;
  
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                arr[i][j] = sc.nextInt();
        int answer = 0;
        for(int i=0; i<n; i++) {
            int cnt = 1;
            boolean isPossible = false;
            for(int j=0; j<n-1; j++) {
                if(arr[i][j] == arr[i][j+1])
                    cnt++;
                else
                    cnt = 1;
                if(cnt >= m)
                    isPossible = true;
            }
            if(isPossible)
                answer++;
        }
        for(int i=0; i<n; i++) {
            int cnt = 1;
            boolean isPossible = false;
            for(int j=0; j<n-1; j++) {
                if(arr[j][i] == arr[j+1][i])
                    cnt++;
                else
                    cnt = 1;
                if(cnt >= m)
                    isPossible = true;
            }
            if(isPossible)
                answer++;
        }
        System.out.println(answer);
        // Please write your code here.
    }
}