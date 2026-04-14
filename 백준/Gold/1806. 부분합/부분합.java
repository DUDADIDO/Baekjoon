import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.IOException;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int[] nums = new int[n];
		int sum = 0;

		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < n; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		int min = 10000000;
		int start = 0;
		int end = 0;
		while (true) {
			if(sum >= m) { // m보다 큰 합이 구해졌으면 min 갱신 후 왼쪽에서 한칸 밈 (숫자를 더 작게 만듬)
				min = Math.min(min, end - start);
				sum -= nums[start++];
			}
			else if(end == n) { // 끝까지 도달했으면 종료
				break;
			}
			else { // m보다 합이 작으면 오른쪽을 한칸 밈(숫자를 더 크게 만듬)
				sum += nums[end++];
			}
		}
		if (min == 10000000)
			System.out.println(0);
		else
			System.out.println(min);
	}
}
