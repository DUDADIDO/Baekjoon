import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static char[][] map;
	
	static void printStar(int n, int x, int y) {
		if(n == 1)
			map[x][y] = '*';
		else {
			int tmp = n/3;
			for(int i=0; i<3; i++) {
				for(int j=0; j<3; j++) {
					if(i==1 && j==1) continue;
					printStar(tmp, x+tmp*i, y+tmp*j);
				}
			}
		}
	}
	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		map = new char[n][n];
		for(int i=0; i<n; i++) {
			Arrays.fill(map[i], ' ');
		}
		printStar(n, 0, 0);
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				sb.append(map[i][j]);
			}
			sb.append("\n");
		}
		System.out.println(sb);
		
		
		
	}
}
