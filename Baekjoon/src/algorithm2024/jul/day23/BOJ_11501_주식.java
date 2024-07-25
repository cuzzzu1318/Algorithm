package algorithm2024.jul.day23;

import java.io.*;
import java.util.*;

public class BOJ_11501_주식 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            int N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            int[] stock = new int[N];
            for (int i = 0; i < N; i++) {
                int n = Integer.parseInt(st.nextToken());
                stock[i] = n;
            }


            int max = 0;
            long benefit = 0;
            for (int i = N - 1; i >= 0; i--) {
                if(stock[i] >= max) {
                    max = stock[i];
                }else{
                    benefit += max-stock[i];
                }
            }
            sb.append(benefit).append("\n");
        }
        System.out.println(sb);
    }
}
