import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static void hanoi(int n, int start, int end, int via) {
		if(n == 1) {
			sb.append(start).append(" ").append(end).append("\n");
		}
		else {
			hanoi(n-1, start, via, end);
			sb.append(start).append(" ").append(end).append("\n");
			hanoi(n-1, via, end, start);
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		System.out.println((int)Math.pow(2,  n) - 1);
		hanoi(n, 1, 3, 2);
		System.out.println(sb);
	}
}
