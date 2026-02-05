import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;



public class Main {
	static int N;
	static int[][] map;
	static final int APPLE = 3;
	static int[] dr = { 0, 1, 0, -1 }; // 오른쪽, 아래, 왼쪽, 위
	static int[] dc = { 1, 0, -1, 0 }; // direction이 L이면 index--     D면 index++
	public static class Move {
		public int time;
		public char direction;
		
		public Move(int time, char direction) {
			this.time = time;
			this.direction = direction;
		}
	}
	public static class Snake {
		public int r;
		public int c;
		public Snake(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int timer = -1;
		N = Integer.parseInt(br.readLine());
		map = new int[N+1][N+1];
		map[1][1] = 1;
		int snakeLenght = 1;
		int K = Integer.parseInt(br.readLine());
		for(int i=0; i<K; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			map[r][c] = APPLE;
		}
		Deque<Move> dq = new ArrayDeque<>();
		Deque<Snake> snake = new ArrayDeque<>();
		snake.add(new Snake(1, 1)); // 뱀 머리 덱 추가
		
		int L = Integer.parseInt(br.readLine());
		for(int i=0; i<L; i++) {
			st = new StringTokenizer(br.readLine());
			int time = Integer.parseInt(st.nextToken());
			char direction = st.nextToken().charAt(0);
			
			dq.add(new Move(time, direction));
		}
		int dirIdx = 0;
		while(true) {
			
			timer++;
//			System.out.println("timer: " + timer + "  curR: " + snake.peekFirst().r + " curC: " + snake.peekFirst().c);
			int curR = snake.peekFirst().r;
			int curC = snake.peekFirst().c;
			if(!dq.isEmpty()) {
				int curCmdTime = dq.peekFirst().time;
				char curCmdDir = dq.peekFirst().direction;
				
				if(curCmdTime == timer) {
//					System.out.println("명령어 실행");
					dq.poll();
					if(curCmdDir == 'L') {   // dr dc index--
						dirIdx--;
						if(dirIdx < 0)
							dirIdx = 3;
					}
					else { //  dr dc index++
						dirIdx++;
						if(dirIdx > 3)
							dirIdx = 0;
					}
				}
			}
			// 머리 한칸 이동
			int nextR = curR + dr[dirIdx];
			int nextC = curC + dc[dirIdx];
						
			// 충돌 한다면
			if(nextR > N || nextR < 1 || nextC > N || nextC < 1 || map[nextR][nextC] == 1) { // 벽에 충돌    또는 몸에 충돌
//				System.out.println("N: " + N + " map: " + map[nextR][nextC] + "  충돌 nextR: " + nextR + " nextC: " + nextC);
				System.out.println(timer+1);
				break;
				// 게임 종료
			}
			// 이동
			if(map[nextR][nextC] == 0) { // 그냥 빈칸이라면
				Snake remove = snake.pollLast();
				map[remove.r][remove.c] = 0;  // 꼬리 하나 줄임(사과 안먹었으니까) 
			}
			else if(map[nextR][nextC] == APPLE) {	
				map[nextR][nextC] = 0;
			}
			snake.addFirst(new Snake(nextR, nextC));
			map[nextR][nextC] = 1;
				

		
		}
		
		
		
	}
}
