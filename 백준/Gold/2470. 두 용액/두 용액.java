import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] water = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			water[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(water);
		
		int start = 0;
		int end = n-1;
		int min = Integer.MAX_VALUE;
		
		int minStartIdx = 0;
		int minEndIdx = 0;
		while(start < end) {
			int sum = water[start] + water[end];
			int abs = Math.abs(sum);
			if(abs < min) {
				min = abs;
				minStartIdx = start;
				minEndIdx = end;
			}
			if(sum <= 0) {
				start++;
			}
			else {
				end--;
			}
		}
		System.out.println(water[minStartIdx] + " " + water[minEndIdx]);
	}
}
