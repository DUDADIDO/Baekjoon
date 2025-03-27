import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int n = sc.nextInt();
        int[][] classes = new int[n][2];
        for(int i=0; i<n; i++) {
            classes[i][0] = sc.nextInt();
            classes[i][1] = sc.nextInt();
        }
        Arrays.sort(classes, (a, b) -> Integer.compare(a[0], b[0])); // 시작시간을 기준으로 배열을 오름차순 정렬
        pq.offer(classes[0][1]);
        for(int i=1; i<n; i++) {
            if(!pq.isEmpty() && classes[i][0] >= pq.peek()) {
                pq.poll();
            }
            pq.offer(classes[i][1]);
        }
        System.out.println(pq.size());

    }
}