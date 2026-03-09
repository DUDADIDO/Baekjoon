import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] parents;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		parents = new int[n+1];
		int[] dest = new int[m];
		for(int i=0; i<=n; i++) {
			parents[i] = i;
		}

		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				int tmp = Integer.parseInt(st.nextToken());
				if(tmp == 1) {
					union(i+1, j+1);
				}
			}
		}
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<m; i++) {
			dest[i] = Integer.parseInt(st.nextToken());
		}
		for(int i=0; i<m-1; i++) {
			if(find(dest[i]) != find(dest[i+1])) {
				System.out.println("NO");
				return;
			}
		}
		System.out.println("YES");
	}
	static void union(int a, int b) {
		int rootA = find(a);
		int rootB = find(b);
		if(rootA != rootB) {
			parents[rootB] = rootA;
		}
	}
	static int find(int a) {
		if(parents[a] == a) return a;
		return parents[a] = find(parents[a]);
	}
	
}
