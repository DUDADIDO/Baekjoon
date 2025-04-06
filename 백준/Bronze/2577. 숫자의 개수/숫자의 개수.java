import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int result = 1;
        for(int i = 0; i < 3; i++) {
            result *= Integer.parseInt(br.readLine());
        }

        int[] count = new int[10];

        String str = Integer.toString(result);
        for (int i = 0; i < str.length(); i++) {
            int digit = str.charAt(i) - '0';  // 문자 '0'을 빼서 정수로 변환
            count[digit]++;
        }
        for (int i = 0; i < 10; i++) {
            System.out.println(count[i]);
        }
    }
}
