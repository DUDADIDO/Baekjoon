class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        
        for(int i=triangle.length - 2; i>=0; i--) { // 아래에서 두번째 줄부터 위로 올라가면서 최댓값을 갱신한다
            for(int j=0; j<triangle[i].length; j++) { // i+1은 아랫줄, 예를들어 문제 설명을 기준으로 5개의 원소가 있는 줄을 의미함. 
                triangle[i][j] += Math.max(triangle[i+1][j], triangle[i+1][j+1]); // i번째 줄에서 j번째 원소의 값은 아래 현재 i번째줄 j번째 원소의 값 + 왼쪽 아래 원소 또는 우측 아래 원소의 값을 더한 것 중 최댓값이다.
            }
        }
        answer = triangle[0][0]; // 위 과정을 반복하면 triangle[0][0]에는 최댓값만 남게 된다.
        return answer;
    }
}