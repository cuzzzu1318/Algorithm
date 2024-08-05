package algorithm2024.jul.day26;

import java.io.*;
import java.util.*;


public class BOJ_2075_N번째큰수 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int[][] map;

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>((o1,o2)->o2-o1);

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                pq.offer(Integer.parseInt(st.nextToken()));
            }
        }
        for (int i = 1; i < N; i++) {
            pq.poll();
        }
        System.out.println(pq.poll());
    }
}
