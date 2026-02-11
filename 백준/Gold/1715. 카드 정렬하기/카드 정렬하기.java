import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		int sum = 0;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		int n = Integer.parseInt(br.readLine());
		
		for(int i=0; i<n; i++) {
			pq.add(Integer.parseInt(br.readLine()));
		}
		for(int i=0; i<n-1; i++) {
			int num1 = pq.poll();
			int num2 = pq.poll();
//			System.out.println("("+num1+", "+num2+")");
			sum += num1 + num2; 
			pq.add(num1+num2);
		}
		int result = pq.poll();
		System.out.println(sum);
		
	}
}
