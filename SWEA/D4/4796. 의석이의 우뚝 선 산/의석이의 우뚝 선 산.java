import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			sb.append("#").append(tc).append(" ");
			List<Integer> list = new ArrayList<>();
			int n = sc.nextInt();
			int sum = 0;
			int[] arr = new int[n];
			int[] up = new int[n];
			int[] down = new int[n];
			for(int i=0; i<n; i++) {
				arr[i] = sc.nextInt();
			}
			int cnt = 1;
			for(int i=1; i<n; i++) {
				if(arr[i] > arr[i-1]) {
					up[i] = cnt++;
				}
				else {
					if(arr[i-1] > 0)
						list.add(i-1);
					cnt = 1;
				}
			}
			cnt = 1;
			for(int i=n-2; i>0; i--) {
				if(arr[i] > arr[i+1]) {
					down[i] = cnt++;
				}
				else {
					cnt = 1;
				}
			}
//			for(int i=0; i<n; i++) {
//				System.out.print(up[i] + " ");
//			}
//			System.out.println();
//			for(int i=0; i<n; i++) {
//				System.out.print(down[i] + " ");
//			}
			for(int idx : list) {
				sum += (up[idx] * down[idx]);
			}
			System.out.println("#" + tc + " " + sum);
			
			
		}
	}
}
