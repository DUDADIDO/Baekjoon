import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int sum = 0;
        int[] heights = new int[9];
        for(int i=0; i<9; i++) {
            heights[i] = Integer.parseInt(br.readLine());
            sum += heights[i]; // 전체 9명의 난쟁이에서 2명의 난쟁이의 키만 빼서 난쟁이의 키가 100이 되는지 검즘하면 됨.
        }
        Arrays.sort(heights); // 오름차순으로 정렬.
        boolean find = false; // 7명의 원래 난쟁이를 찾았는지 확인할 때 사용하는 플래그

        for(int i=0; i<9; i++) { // 첫 번째 난쟁이
            for(int j=i+1; j<9; j++) { // 두 번째 난쟁이
                if(sum - (heights[i] + heights[j]) == 100) { // 전체 나쟁이에서 두 난쟁이의 키를 빼서 100이 나오는가 (나오면 그 두 난쟁이를 제외 한 나머지 난쟁이가 진짜 난쟁이)
                    for(int k=0; k<9; k++) { // 난쟁이들 출력
                        if(k == i || k == j)  // 두 나쟁이를 제외하고 출력
                            continue;
                        
                        System.out.println(heights[k]); // 출력
                    }
                    find = true; // flag true
                    break; // 중지
                }
            }
            if(find) // 찾았으면 중지
                break;
        }

    }
}