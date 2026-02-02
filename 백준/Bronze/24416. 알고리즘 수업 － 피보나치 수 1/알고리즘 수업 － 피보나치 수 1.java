import java.util.Scanner;

public class Main {
	static int[] fibArr = new int[41];
	static int cntRecur;
	static int fib(int n) {
		int cnt = 0;
		for(int i=3; i<=n; i++) {
			fibArr[i] = fibArr[i-1] + fibArr[i-2];
			cnt++;
		}
		return cnt;
	}
	static int fibRecur(int n) {
		
		if(n <= 2) {
			cntRecur++;
			return 1;
		}
			
		else
			return fibRecur(n-1) + fibRecur(n-2);
			
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);	
		fibArr[1] = 1;
		fibArr[2] = 1;
		int n = sc.nextInt();
		fibRecur(n);
		System.out.println(cntRecur + " " + fib(n));
		
		
	}
}
