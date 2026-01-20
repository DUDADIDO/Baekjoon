import java.io.IOException;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			int max = Integer.MIN_VALUE;
			int N = sc.nextInt();
			int M = sc.nextInt();
			M--;
			int[][] map = new int[N][N];
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					int sum = 0;
					for(int x=j-M; x<=j+M; x++) {
						if(x<0 || x>=N) continue;
						sum += map[i][x];
					}
					for(int y=i-M; y<=i+M; y++) {
						if(y<0 || y>=N) continue;
						sum += map[y][j];
					}
					sum -= map[i][j];
					if(sum > max)
						max = sum;
					sum = 0;
					for(int x=-M; x<=M; x++) {
						int nx = j + x;
						int ny = i + x;
						if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
						sum += map[ny][nx];
					}
					for(int x=-M; x<=M; x++) {
						int nx = j + x;
						int ny = i - x;
						if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
						sum += map[ny][nx];
					}
					sum -= map[i][j];
					if(sum > max)
						max = sum;
					
					
				}
			}
			System.out.println("#" + tc + " " + max);
			
		}

	}

}
