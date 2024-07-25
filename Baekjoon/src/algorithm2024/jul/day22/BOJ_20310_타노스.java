package algorithm2024.jul.day22;

import java.io.*;
import java.util.*;


public class BOJ_20310_타노스 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        String s = br.readLine();
        int cntZero = 0;
        int cntOne = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                cntZero++;
            }
            if (s.charAt(i) == '1') {
                cntOne++;
            }
        }
        cntZero/=2;
        cntOne/=2;

        boolean[] check = new boolean[s.length()];
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i)=='1'){
                if(cntOne>0){
                    cntOne--;
                    check[i] = true;
                }
            }
            if(s.charAt(s.length()-1-i)=='0'){
                if (cntZero > 0) {
                    cntZero--;
                    check[s.length()-1-i] = true;
                }
            }
        }
//        System.out.println(Arrays.toString(check));
        for (int i = 0; i < s.length(); i++) {
            if(!check[i]){
                sb.append(s.charAt(i));
            }
        }
        System.out.println(sb);
    }
}
