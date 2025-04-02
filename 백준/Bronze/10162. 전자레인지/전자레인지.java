import java.util.*;

class Main {
    public static void main(String[] args) {
        int buttonA = 300;
        int buttonB = 60;
        int buttonC = 10;
        int aCnt = 0;
        int bCnt = 0;
        int cCnt = 0;
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        aCnt = T / buttonA;
        T = T % buttonA;
        bCnt = T / buttonB;
        T = T % buttonB;
        cCnt = T / buttonC;
        T = T % buttonC;
        if(T != 0) {
            System.out.println("-1");
            return;
        }
        System.out.println(aCnt + " " + bCnt + " " + cCnt);


    }
}