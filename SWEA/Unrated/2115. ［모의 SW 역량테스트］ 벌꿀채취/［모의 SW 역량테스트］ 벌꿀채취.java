import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//메모리: 27,264 KB, 시간: 101 ms
public class Solution {
    static int N, M, C, maxSum; // N:맵 크기     M:연속으로 선택 할 꿀통의 개수    C:선택한 꿀통으로 얻을 수 있는 최대 이득 제한     maxSum:현재 선택한 꿀통으로 얻는 최대이득
    static int[][] map, sumArr; // 꿀통의 정보를 담은 2차원 배열
    static void dfs(int L, int sum, int powSum, int[] selected) {
        if(sum > C) // 현재 합이 C를 넘는다면 바로 종료(가지치기)
            return;
        if(L == M) { // 끝까지 탐색 했다면
            maxSum = Math.max(maxSum, powSum); // maxSum 갱신
            return;
        }

        dfs(L+1, sum + selected[L], powSum + (selected[L] * selected[L]), selected); // 이번 꿀통을 골랐다면
        dfs(L+1, sum, powSum, selected); // 이번 꿀통을 고르지 않았다면

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for(int tc=1; tc<=T; tc++) {
            sb.append("#").append(tc).append(" ");
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            map = new int[N][N];
            sumArr = new int[N][N];
            for(int i=0; i<N; i++) 
            	Arrays.fill(sumArr[i], -1);
            
            int maxBenefit = 0;
            for(int i=0; i<N; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for(int r1=0; r1<N; r1++) {
                for(int c1=0; c1<=N-M; c1++) {
                	int maxSumOne;
                	if(sumArr[r1][c1] != -1) {
                		maxSumOne = sumArr[r1][c1];
                	}
                	else {
                        int[] selectedOne = new int[M];
                        for(int i=0; i<M; i++)
                            selectedOne[i] = map[r1][c1+i]; // 1번 일꾼이 선택 한 꿀벌 통들(가로로 연속되게 M개를 고름)
                        maxSum = 0; // maxSum 초기화 (static 변수)
                        dfs(0, 0, 0, selectedOne); 
                        maxSumOne = maxSum;
                        sumArr[r1][c1] = maxSumOne;
                	}
                    // 계산

                    for(int r2=r1; r2<N; r2++) { // 2번 일꾼은 1번 일꾼이 했던 이전행에는 갈 필요 없음. 따라서 r2=r1 에서부터 시작
                        for(int c2=0; c2<=N-M; c2++) {
                            if(r2 == r1 && c2 < c1+M) // 같은 행에 있고, 겹치게 골랐다면 패스
                                continue;
                            int maxSumTwo;
                            if(sumArr[r2][c2] != -1) {
                            	maxSumTwo = sumArr[r2][c2];
                            }
                            else {
                                int[] selectedTwo = new int[M];
                                for(int i=0; i<M; i++)
                                    selectedTwo[i] = map[r2][c2+i]; // 2번 일꾼이 선택 한 꿀벌 통들(가로로 연속되게 M개를 고름)
                                // 계산
                                maxSum = 0;
                                dfs(0, 0, 0, selectedTwo);
                                maxSumTwo = maxSum;
                                sumArr[r2][c2] = maxSumTwo;
                            }


                            maxBenefit = Math.max(maxBenefit, maxSumOne+maxSumTwo);
                        }
                    }


                }
            }

            sb.append(maxBenefit).append("\n");


        }
        System.out.println(sb);

    }
}