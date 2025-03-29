import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        int max = Integer.MIN_VALUE; // 예산의 최대값 (초기 이분탐색의 right)

        for(int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
            max = Math.max(max, arr[i]);
        }
        int m = sc.nextInt();
        int left = 0; // 초기 이분탐색의 left는 0으로 초기화
        int right = max; // 초기 이분탐색의 right는 max
        int answer = 0; // 정답
        while(left <= right) { // left가 right보다 작은 동안 반복해서 실행
            int mid = (left + right) / 2; // 중간값 (상한선)
            long total = 0; // 상한선 이하의 예산들의 합
            for(int i=0; i<n; i++) {
                total += Math.min(arr[i], mid); // 해당 예산이 상한선보다 낮으면 그대로 예산을 더하고 상한선 보다 높으면 상한선을 더한다.
            }
            if(total <= m) { // 현재 탐색중인 상한선을 이용한 예산들의 합이 전체 예산 m보다 작으면
                answer = mid; // 정답으로 저장하고
                left = mid + 1; // 상한선을 늘린다.
            }
            else { // 현재 탐색중인 상한선을 이용한 예산들의 합이 전체 예산 m을 넘어서므로 상한선을 줄인다.
                right = mid - 1;
            }
        }

        System.out.println(answer); // 정답을 출력
    }
}