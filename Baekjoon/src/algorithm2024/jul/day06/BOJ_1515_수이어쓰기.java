package algorithm2024.jul.day06;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_1515_수이어쓰기 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        String s= br.readLine();
        int base = 0;
        int idx = 0;
        while (base++<=30000) {
            String baseStr = String.valueOf(base);
            for(int i = 0;i < baseStr.length();i++) {
                if(baseStr.charAt(i) == s.charAt(idx)) {
                    idx++;
                }
                if(idx == s.length()) {
                    sb.append(baseStr);
                    System.out.println(sb);
                    return;
                }
            }
        }

    }

}
