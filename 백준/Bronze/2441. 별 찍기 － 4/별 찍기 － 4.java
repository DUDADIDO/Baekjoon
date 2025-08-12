import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int cnt = 0;
        for(int i=n; i>0; i--) {
            for(int j=0; j<n; j++) {
                if(j >= cnt)
                    System.out.print("*");
                else
                    System.out.print(" ");
            }
            System.out.println();
            cnt++;
        }
    }
}