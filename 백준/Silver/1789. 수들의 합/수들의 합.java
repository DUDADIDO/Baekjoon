import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cnt = 0;
        long sum = 0;
        long i = 1;
        long n = Long.parseLong(br.readLine());
        while(sum < n) {
            sum += i;
            cnt++;
            i++;
        }
        if(sum == n) {
            cnt++;
        }
        System.out.println(cnt-1);
    }
}