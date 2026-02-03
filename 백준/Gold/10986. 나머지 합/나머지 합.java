import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
0의 개수 카운트
같은것 끼리 개수 샘 : n
nC2 한걸 다 더하면 답
*/
public class Main {
	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		long[] arr = new long[N+1];
		long[] sumArr = new long[N+1];
		long[] combArr = new long[M+1];
		st = new StringTokenizer(br.readLine());
		long sum = 0;
		
		for(int i=1; i<=N; i++) {
			arr[i] = Integer.parseInt(st.nextToken()) % M;
			sum = (sum + arr[i]) % M;
			sumArr[i] = sum;
		}
		
		long cntZero = 0;
		long cntComb = 0;
		for(int i=1; i<=N; i++) {
			if(sumArr[i] == 0)
				cntZero++;
			combArr[(int) sumArr[i]]++;
		}
		for(int i=0; i<M; i++) {
			long combN =  combArr[i];
			long result = (combN * (combN-1) / 2);
			cntZero += result;
		}
		
		System.out.println(cntZero);
		
	}
}
