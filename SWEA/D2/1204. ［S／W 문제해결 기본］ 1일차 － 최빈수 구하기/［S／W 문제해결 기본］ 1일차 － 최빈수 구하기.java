import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		/*
		   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		*/

		for(int test_case = 1; test_case <= T; test_case++)
		{
            int n = sc.nextInt();
            int[] scores = new int[101];
            for(int i=0; i<1000; i++) {
                scores[sc.nextInt()]++;
            }
            int maxValue = 0;
            int maxIndex = 0;
            for(int i=1; i<=100; i++) {
                if(scores[i] >= maxValue) {
                    maxValue = scores[i];
                    maxIndex = i;
                }
            }
            
            System.out.println("#" + n + " " + maxIndex);
            
            
            
			/////////////////////////////////////////////////////////////////////////////////////////////
			/*
				 이 부분에 여러분의 알고리즘 구현이 들어갑니다.
			 */
			/////////////////////////////////////////////////////////////////////////////////////////////

		}
	}
}