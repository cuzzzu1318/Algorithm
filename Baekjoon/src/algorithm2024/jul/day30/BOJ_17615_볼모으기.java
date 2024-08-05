package algorithm2024.jul.day30;

import java.io.*;
import java.util.*;

public class BOJ_17615_볼모으기 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int min = Integer.MAX_VALUE;


    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        char[] s=  br.readLine().toCharArray();
        int cntRed = 0;
        int cntBlue = 0;

        for (int i = 0; i < N; i++) {
            char c = s[i];
            if(c == 'R') {
                cntRed++;
            }else{
                cntBlue++;
            }
        }
        if(cntRed==0||cntBlue==0) {
            System.out.println("0");
        }else{
            int firstCnt=0;
            for (int i = 0; i < N; i++) {
                if(s[i]=='B'){
                    firstCnt++;
                }else{
                    break;
                }
            }
            min = Math.min(min, cntBlue-firstCnt);



            if(min!=0){
                firstCnt =0;
                for (int i = 0; i < N; i++) {
                    if(s[i]=='R'){
                        firstCnt++;
                    }else{
                        break;
                    }
                }
                min = Math.min(min, cntRed-firstCnt);
            }

            if(min!=0){
                firstCnt=0;
                for(int i = N-1;i>=0;i--){
                    if(s[i]=='R'){
                        firstCnt++;
                    }else{
                        break;
                    }
                }

                min = Math.min(min, cntRed-firstCnt);
            }

            if(min!=0){
                firstCnt=0;
                for(int i = N-1;i>=0;i--){
                    if(s[i]=='B'){
                        firstCnt++;
                    }else{
                        break;
                    }
                }
                min = Math.min(min, cntBlue-firstCnt);
            }
            System.out.println(min);
        }
    }

}
