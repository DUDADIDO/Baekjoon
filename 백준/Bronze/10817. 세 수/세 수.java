import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        int mid = 0;
        if( (b <= a && a <= c) || (c <= a && a <= b) )
            mid = a;
        else if( (a <= b && b <= c) || (c <= b && b <= a) )
            mid = b;
        else
            mid = c;

        System.out.println(mid);
    }
}