import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int T=Integer.parseInt(br.readLine());
        StringBuilder sb=new StringBuilder();
        for(int tc=1;tc<=T;tc++) {
            int c=Integer.parseInt(br.readLine());
            int length=0;
            int speed=0;
            for(int i=0;i<c;i++) {
                StringTokenizer st=new StringTokenizer(br.readLine());
                int mode=Integer.parseInt(st.nextToken());
                if(mode==1) {
                    speed+=Integer.parseInt(st.nextToken());
                }
                else if(mode==2) {
                    speed-=Integer.parseInt(st.nextToken());
                    if(speed<0)speed=0;
                }
                length+=speed;
            }
            sb.append("#").append(tc).append(" ").append(length).append("\n");
        }
        System.out.println(sb);
    }

}