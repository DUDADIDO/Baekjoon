import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[10001];
		Arrays.fill(arr,  1);
		
		for(int i=2; i<=10000; i++) {
			arr[i] += arr[i-2];
		}
		for(int i=3; i<=10000; i++) {
			arr[i] += arr[i-3];
		}
		
		for(int i=0; i<n; i++) {
			int num = Integer.parseInt(br.readLine());
			
			System.out.println(arr[num]);
		}
	}
}
