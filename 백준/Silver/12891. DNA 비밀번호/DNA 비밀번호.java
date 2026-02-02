import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException, NumberFormatException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Map<Character, Integer> map = new HashMap<>();
		StringTokenizer st;
		int answer = 0;
		int[] target = new int[4];
		st = new StringTokenizer(br.readLine());
		int S = Integer.parseInt(st.nextToken()); // 전체 문자열 길이
		int P = Integer.parseInt(st.nextToken()); // 암호문 문자열 길이      전체 문자열에서 암호문 문자열 만큼의 윈도우 슬라이드
		String dnaStr = br.readLine();
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<4; i++) {
			target[i] = Integer.parseInt(st.nextToken());
		}
		for(int i=0; i<P-1; i++)  // 초기 창문 (P보다 1개 작개)
			map.put(dnaStr.charAt(i), map.getOrDefault(dnaStr.charAt(i), 0)+1);
		for(int i=P-1; i<S; i++) {
			map.put(dnaStr.charAt(i), map.getOrDefault(dnaStr.charAt(i), 0)+1); // 윈도우에 하나 put
//			System.out.println(map.toString());
			if(map.getOrDefault('A', 0) >= target[0] && map.getOrDefault('C', 0) >= target[1]  // 윈도우 다 찼으니까 비교
					&& map.getOrDefault('G', 0) >= target[2] && map.getOrDefault('T', 0) >= target[3]) {
				answer++; // 암호문 되면 ++
			}
			map.put(dnaStr.charAt(i-P+1), map.getOrDefault(dnaStr.charAt(i-P+1), 0)-1); // 마지막 창문 빼기
		}
		System.out.println(answer);
		
	}
}
