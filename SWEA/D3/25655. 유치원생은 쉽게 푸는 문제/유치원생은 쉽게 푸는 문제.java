
import java.util.Scanner;
import java.io.FileInputStream;


class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int x = sc.nextInt();

			if(x == 1) {
				System.out.println("0");
			}
			else if(x == 2) {
				System.out.println("8");
			}
			else {
				if(x % 2 == 0) {
					for(int i=0; i<x/2; i++) {
						System.out.print("8");
					}
				}
				else {
					System.out.print("4");
					for(int i=0; i<x/2; i++) {
						System.out.print("8");
					}
				}
				System.out.println();
			}
			
		}
	}
}