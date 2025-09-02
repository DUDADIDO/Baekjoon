class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] check = new boolean[n];
        for(int i=0; i<n; i++) {
            if(!check[i]) { // 아직 i번 노드를 방문하지 않았다면 방문한다.
                DFS(n, computers, check, i);
                ++answer;
            }
        }
        return answer;
    }
    public void DFS(int n, int[][] computers, boolean[] check, int index) {
        check[index] = true;
        for(int i=0; i<n; i++) {
            if(!check[i] && (computers[index][i] == 1) ) { // 아직 i번 노드를 방문하지 않았으면서, index번 노드와 i번 노드가 이어져있다면 DFS를 재귀
                DFS(n, computers, check, i);
            }
        }
    }
}