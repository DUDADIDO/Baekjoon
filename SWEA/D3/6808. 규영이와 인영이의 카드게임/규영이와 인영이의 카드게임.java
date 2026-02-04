import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;



public class Solution {
	final static int CARD_SIZE = 9;
    static int[] pm, visit, cardTwo, cardOne;
    static int winOne, winTwo, cnt;;
    static StringBuilder sb = new StringBuilder();
    public static void DFS(int L) {
        // L은 현재 뽑은 카드의 개수 (Level)
        if (L == CARD_SIZE) {
//        	cnt++;
        	int scoreOne = 0;
        	int scoreTwo = 0;
        	
        	for(int i=0; i<CARD_SIZE; i++) {
        		if(cardOne[i] > pm[i]) 
        			scoreOne += (cardOne[i] + pm[i]);
        		else 
        			scoreTwo += (cardOne[i] + pm[i]);
        	}
    		if(scoreOne > scoreTwo)
    			winOne++;
    		else if(scoreOne < scoreTwo)
    			winTwo++;
        	
        } else {
            for (int i = 0; i < CARD_SIZE; i++) {
                if (visit[i] == 0) { // 방문하지 않은 숫자라면
                    visit[i] = 1; // 방문 처리
                    pm[L] = cardTwo[i]; // 순열에 숫자 추가
                    DFS(L + 1); // 다음 숫자 선택하러 재귀
                    visit[i] = 0; // 백트래킹: 돌아와서 방문 처리 해제
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st;
    	int T = Integer.parseInt(br.readLine());
    	for(int tc=1; tc<=T; tc++) {
    		sb.append("#").append(tc).append(" ");
    		boolean[] cardDeck = new boolean[19];
    		cardOne = new int[CARD_SIZE]; // 고정 카드
    		cardTwo = new int[CARD_SIZE]; // 순열 생성 해야하는 카드 경우의 수
    		visit = new int[CARD_SIZE];
    		pm = new int[CARD_SIZE];
    		winOne = winTwo = 0;
    		int cntOne = 0;
    		int cntTwo = 0;
    		st = new StringTokenizer(br.readLine());
    		
    		for(int i=0; i<9; i++) {
    			cardDeck[Integer.parseInt(st.nextToken())] = true;
    		}
    		for(int i=1; i<=18; i++) {
    			if(cardDeck[i]) {
    				cardOne[cntOne] = i;
    				cntOne++;
    			}
    			else {
    				cardTwo[cntTwo] = i;
    				cntTwo++;
    			}
    		}
    		DFS(0);
    		sb.append(winOne).append(" ").append(winTwo).append("\n");
    	}
		System.out.println(sb);
    }
}

