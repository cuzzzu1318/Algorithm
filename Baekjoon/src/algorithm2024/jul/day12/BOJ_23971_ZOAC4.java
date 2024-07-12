package algorithm2024.jul.day12;

import java.io.*;
import java.util.*;

public class BOJ_23971_ZOAC4 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int H,W,N,M;

    public static void main(String[] args) throws Exception{
        st = new StringTokenizer(br.readLine());

        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int wid = 0;
        for (int i = 0; i < H; i+=N+1) {
            wid++;
        }
        int height = 0;
        for (int i = 0; i < W; i += M+1) {
            height++;
        }
        System.out.println(wid*height);
    }
}
