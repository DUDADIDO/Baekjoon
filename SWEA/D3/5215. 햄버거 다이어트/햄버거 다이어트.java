import java.util.Scanner;
class food {
    public int kalo;
    public int score;
    public food(int kalo, int score) {
        this.kalo = kalo;
        this.score = score;
    }
}

class Solution
{

            
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
			int N = sc.nextInt();
            int L = sc.nextInt();
            food[] foods = new food[N];
            int[] dp = new int[L +1 ];
            for(int i=0; i<N; i++) {
                int score = sc.nextInt();
                int kalo = sc.nextInt();
                foods[i] = new food(kalo, score);
            }
            
            for(int i=0; i<N; i++) {
                int currentKalo = foods[i].kalo;
                int currentScore = foods[i].score;
                
                for(int j=L; j>=currentKalo; j--) {
                    dp[j] = Math.max(dp[j], dp[j-currentKalo] + currentScore);
                }

            }
            System.out.println("#" + test_case + " " + dp[L]);             
                                     
            
            

		}
	}
}