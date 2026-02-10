import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int min;
	static int[] plan, prices;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		for(int tc=1; tc<=T; tc++) {
			sb.append("#").append(tc).append(" ");
			prices = new int[4];
			plan = new int[12];
			visited = new boolean[12];
			min = Integer.MAX_VALUE;
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<4; i++) {
				prices[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<12; i++) {
				plan[i] = Integer.parseInt(st.nextToken());
			}
			
			makePlan(0, 0);
			sb.append(min).append("\n");
		}
		System.out.println(sb);
	}
	
	static void makePlan(int month, int sum) {
		if(month == 12) { // 12개월치 계획을 다 세웠다면
			min = Math.min(min, Math.min(sum, prices[3]));
			return;
		}
		
		if(sum >= min) 
			return;
		
		if(plan[month] == 0 || visited[month]) { // 해당 달의 이용권을 이미 결재 했거나(3달치) 또는 이용 계획이 없다면 다음 달로 이동
			makePlan(month+1, sum);
		}
		for(int i=0; i<3; i++) { // 각 1일권, 한달권, 3개월 권에 대해 계산 실시
			if(i == 0) { // 1일권
				int daily = prices[i] * plan[month];
				visited[month] = true;
				makePlan(month+1, sum+daily);
				visited[month] = false;
			}
			else if(i == 1) { // 한달권
				int monthly = prices[i];
				visited[month] = true;
				makePlan(month+1, sum+monthly);
				visited[month] = false;
				
			}
			else { // 3달권   (현재 달로부터 총 3달치를 비교해서 3달권을 쓸지 한달권을 쓸지 결정?  아니면 현재 달로부터 이전 3달치를 합쳐서 결정?)
				if(month <= 9) {
					int threeMonthly = prices[i];
					visited[month] = visited[month+1] = visited[month+2] = true;
					makePlan(month+1, sum+threeMonthly);
					visited[month] = visited[month+1] = visited[month+2] = false;
				}
			}
		}
		
	}
}
