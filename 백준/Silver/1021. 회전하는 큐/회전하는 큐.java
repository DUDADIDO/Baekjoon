import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int cnt = 0;

        LinkedList<Integer> deque = new LinkedList<>();

        for(int i=1; i<=N; i++) {
            deque.addLast(i);
        }
        st = new StringTokenizer(br.readLine());
        while(st.hasMoreTokens()) {
            int k = Integer.parseInt(st.nextToken());
            int cntOne = deque.indexOf(k);
            int cntTwo = deque.size() - deque.indexOf(k);
            if(cntOne < cntTwo) {
                for(int i=0; i<cntOne; i++) {
                    deque.addLast(deque.removeFirst());
                }
                cnt += cntOne;
            }
            else {
                for(int i=0; i<cntTwo; i++) {
                    deque.addFirst(deque.removeLast());
                }
                cnt += cntTwo;
            }
            deque.removeFirst();

        }
        System.out.println(cnt);

    }
}