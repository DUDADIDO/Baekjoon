import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int sum = 0;
		int cnt = 9;
		int n = Integer.parseInt(br.readLine());
		Map<Character, Integer> hm = new HashMap<>();
		
		for(int i=0; i<n; i++)  {
			String word = br.readLine();
			int weight = (int)Math.pow(10, word.length()-1);
			for(int idx=0; idx<word.length(); idx++) {
				char c  = word.charAt(idx);
				hm.put(c, hm.getOrDefault(c, 0) + weight);
				weight /= 10;
			}
		}
		List<Integer> weights = new ArrayList<>(hm.values());
		weights.sort(Collections.reverseOrder());
		for(int i=0; i<weights.size(); i++) {
			sum += weights.get(i)*cnt--;
		}
		System.out.println(sum);
		
	}
}
