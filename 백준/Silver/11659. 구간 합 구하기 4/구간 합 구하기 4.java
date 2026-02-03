import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] nArr = new int[N+1];
		
		st = new StringTokenizer(br.readLine());
		int sum = 0;
		for(int i=1; i<=N; i++) {
			sum += Integer.parseInt(st.nextToken());
			nArr[i] = sum;
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
//			System.out.println("start: " + start + "   end: " + end);
			int result = nArr[end] - nArr[start-1];
			sb.append(result).append("\n");
		}
		System.out.println(sb);
		
		
	}
}
