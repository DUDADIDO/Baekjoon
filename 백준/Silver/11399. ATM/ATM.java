import java.io.*;
import java.util.*;

class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int sum = 0;
        Arrays.sort(arr);
        for(int i=0; i<n; i++) {
            for(int j=0; j<=i; j++) {
                sum += arr[j];
            }
        }
        System.out.print(sum);
    }
}