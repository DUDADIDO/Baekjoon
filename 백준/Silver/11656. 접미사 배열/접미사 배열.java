import java.util.Arrays;
import java.util.Scanner;

public class Main { 
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String s = sc.next();
		String[] strArr = new String[s.length()];
		strArr[0] = s;
		for(int i=1; i<strArr.length; i++) {
			strArr[i] = s.substring(i, s.length());
		}
		
		Arrays.sort(strArr);
		for(String tmp : strArr) { // 출력
			System.out.println(tmp); 
		}
	}
}
