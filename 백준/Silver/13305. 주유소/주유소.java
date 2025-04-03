import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] oil = new int[n]; // 각 도시의 기름 값
        int[] range = new int[n-1]; // 도로의 거리
        for(int i=0; i<n-1; i++) {
            range[i] = sc.nextInt();
        }
        for(int i=0; i<n; i++) {
            oil[i] = sc.nextInt();
        }
        long result = 0; // 결과 값
        long minPrice = oil[0]; // 현재까지 방문한 도시들 중 최소 기름값
        for(int i=0; i<n-1; i++) {
            if(oil[i] < minPrice) {
                minPrice = oil[i]; // 최저 기름값이 바뀌게 되면 갱신 한다. 이후로 이동하는 거리는 전부 이 기름값을 통해 이동한다.
            }
            result += minPrice * range[i]; // 현재까지 방문 한 도시 중 가장 저렴한 기름값으로 기름을 채운다.
        }
        System.out.println(result);

    }
}