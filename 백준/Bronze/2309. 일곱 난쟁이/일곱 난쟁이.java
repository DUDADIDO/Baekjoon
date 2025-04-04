import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] heights = new int[9];
        for(int i=0; i<9; i++) {
            heights[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(heights);
        for(int i=0; i<9; i++) {
            for(int j=i+1; j<9; j++) {
                for(int k=j+1; k<9; k++) {
                    for(int l=k+1; l<9; l++) {
                        for(int m=l+1; m<9; m++) {
                            for(int n=m+1; n<9; n++) {
                                for(int o=n+1; o<9; o++) {
                                    if(heights[i] + heights[j] + heights[k] + heights[l] + heights[m] + heights[n] + heights[o] == 100) {
                                        System.out.println(heights[i]);
                                        System.out.println(heights[j]);
                                        System.out.println(heights[k]);
                                        System.out.println(heights[l]);
                                        System.out.println(heights[m]);
                                        System.out.println(heights[n]);
                                        System.out.println(heights[o]);
                                        return;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}