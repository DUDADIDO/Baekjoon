import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> {
			if(Math.abs(o1) == Math.abs(o2))
					return o1-o2;
			return Math.abs(o1) - Math.abs(o2);
		});
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		for(int i=0; i<n; i++) {
			int num = Integer.parseInt(br.readLine());
			if(num == 0) {
				if(!pq.isEmpty())
					sb.append(pq.poll()).append("\n");
				else
					sb.append("0\n");
			}
			else {
				pq.add(num);
			}
		}
		System.out.println(sb);
		
	}
}
