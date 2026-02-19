import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.IOException;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		//		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[3];
		//		int[][] dpMax = new int[n][3];
		//		int[][] dpMin = new int[n][3];
		int[] maxArr = new int[3];
		int[] minArr = new int[3];
		int[] tmpMaxArr = new int[3];
		int[] tmpMinArr = new int[3];
		StringTokenizer st;
		//		for(int i=0; i<n; i++) {
		//			st = new StringTokenizer(br.readLine());
		//			for(int j=0; j<3; j++) {
		//				arr[i][j] = Integer.parseInt(st.nextToken());
		//			}
		//		}
		//		dpMax[0][0] = dpMin[0][0] = arr[0][0];
		//		dpMax[0][1] = dpMin[0][1] = arr[0][1];
		//		dpMax[0][2] = dpMin[0][2] = arr[0][2];
		//		for(int i=1; i<n; i++) {
		//			dpMax[i][0] = Math.max(dpMax[i-1][0], dpMax[i-1][1]) + arr[i][0];
		//			dpMax[i][1] = Math.max(dpMax[i-1][0], Math.max(dpMax[i-1][1], dpMax[i-1][2])) + arr[i][1];
		//			dpMax[i][2] = Math.max(dpMax[i-1][1], dpMax[i-1][2]) + arr[i][2];
		//			
		//			dpMin[i][0] = Math.min(dpMin[i-1][0], dpMin[i-1][1]) + arr[i][0];
		//			dpMin[i][1] = Math.min(dpMin[i-1][0], Math.min(dpMin[i-1][1], dpMin[i-1][2])) + arr[i][1];
		//			dpMin[i][2] = Math.min(dpMin[i-1][1], dpMin[i-1][2]) + arr[i][2];
		//		}
		//		
		st = new StringTokenizer(br.readLine());
		maxArr[0] = minArr[0] = Integer.parseInt(st.nextToken());
		maxArr[1] = minArr[1] = Integer.parseInt(st.nextToken());
		maxArr[2] = minArr[2] = Integer.parseInt(st.nextToken());

		for(int i=1; i<n; i++) {
			st = new StringTokenizer(br.readLine());

			arr[0] = Integer.parseInt(st.nextToken());
			arr[1] = Integer.parseInt(st.nextToken());
			arr[2] = Integer.parseInt(st.nextToken());
			tmpMaxArr[0] = Math.max(maxArr[0], maxArr[1]) + arr[0];
			tmpMaxArr[1] = Math.max(maxArr[0], Math.max(maxArr[1], maxArr[2])) + arr[1];
			tmpMaxArr[2] = Math.max(maxArr[1], maxArr[2]) + arr[2];

			tmpMinArr[0] = Math.min(minArr[0], minArr[1]) + arr[0];
			tmpMinArr[1] = Math.min(minArr[0], Math.min(minArr[1], minArr[2])) + arr[1];
			tmpMinArr[2] = Math.min(minArr[1], minArr[2]) + arr[2];

			for(int k=0; k<3; k++) {
				minArr[k] = tmpMinArr[k];
				maxArr[k] = tmpMaxArr[k];
			}

		}


		int min = Math.min(minArr[0], Math.min(minArr[1], minArr[2]));
		int max = Math.max(maxArr[0], Math.max(maxArr[1], maxArr[2]));

		StringBuilder sb = new StringBuilder();
		sb.append(max).append(" ").append(min);
		System.out.println(sb);
	}
}
