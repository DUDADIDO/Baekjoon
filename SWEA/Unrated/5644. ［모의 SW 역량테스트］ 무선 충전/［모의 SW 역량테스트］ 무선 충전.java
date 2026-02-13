import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static class BC {
		int r;
		int c;
		int size;
		int power;
		public BC(int r, int c, int size, int power) {
			super();
			this.r = r;
			this.c = c;
			this.size = size;
			this.power = power;
		}
	}
	static class User {
		int r, c;

		public User(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
		
	}
	static User userA;
	static User userB;
	static int moveIdx, m, a, moveA[], moveB[];
	static BC bc[];
	static int[] dr = { 0, -1, 0, 1, 0 };
	static int[] dc = { 0, 0, 1, 0, -1 };
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			int sum = 0;
			sb.append("#").append(tc).append(" ");
			StringTokenizer st = new StringTokenizer(br.readLine());
			m = Integer.parseInt(st.nextToken());
			a = Integer.parseInt(st.nextToken());
			moveA = new int[m];
			moveB = new int[m];
			userA = new User(0, 0);
			userB = new User(9, 9);
			moveIdx = 0;
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<m; i++) {
				moveA[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<m; i++) {
				moveB[i] = Integer.parseInt(st.nextToken());
			}
			bc = new BC[a];
			for(int i=0; i<a; i++) {
				st = new StringTokenizer(br.readLine());
				int c = Integer.parseInt(st.nextToken()) - 1;
				int r = Integer.parseInt(st.nextToken()) - 1;
				int size = Integer.parseInt(st.nextToken());
				int power = Integer.parseInt(st.nextToken());
				bc[i] = new BC(r, c, size, power);
			}
			sum += calc();
			for(int timer=0; timer<m; timer++) {
				move();
				sum += calc();
			}
			sb.append(sum).append("\n");			
		}
		System.out.println(sb);
	}
	static int calc() {
		int max = 0;  //현재 초의 최대 충전량
		for(int i=0; i<a; i++){  //i:사용자 A가 선택한 배터리
			for(int j=0; j<a; j++){//j:사용자 B가 선택한 배터리
					boolean checkA = check(i, 1);  // 사용자  A가 i배터리에 접속가능하다면 true
					boolean checkB = check(j, 2);  // 사용자  B가 j배터리에 접속가능하다면 true
					
					int curSum = 0;
					//같은 배터리이고 둘 다 접속 가능한 경우
					if( i==j && checkA && checkB ){
						curSum = bc[i].power;
					}
					//그 외의 경우
					else{
					  if(checkA) curSum += bc[i].power;
					  if(checkB) curSum += bc[j].power;
					}
					max = Math.max( max, curSum );
			}
		}
		return max;
	}
	static void move() {
		userA.r = userA.r + dr[moveA[moveIdx]];
		userA.c = userA.c + dc[moveA[moveIdx]];
		userB.r = userB.r + dr[moveB[moveIdx]];
		userB.c = userB.c + dc[moveB[moveIdx]];
		moveIdx++;
	}
	static boolean check(int batNum, int user) {
		if(user == 1) {
			int distance = Math.abs(userA.r - bc[batNum].r) + Math.abs(userA.c - bc[batNum].c);
			if(distance <= bc[batNum].size) {
				return true;
			}
		}
		else {
			int distance = Math.abs(userB.r - bc[batNum].r) + Math.abs(userB.c - bc[batNum].c);
			if(distance <= bc[batNum].size) {
				return true;
			}
		}
		
		return false;
	}
}
