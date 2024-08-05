package algorithm2024.jul.day30;

import java.io.*;
import java.util.*;

public class BOJ_20922_겹치는건싫어 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int N, K;


    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        HashMap<Integer, Integer> map = new HashMap<>();
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        int[] cnt = new int[100_001];
        int len = 0;
        int max = 0;
        for (int i = 0; i < N; i++) {
            int n = Integer.parseInt(st.nextToken());
            arr[i] = n;
        }
        int start = 0;
        int end = 0;

        while(end<N){
            while(end<N&&cnt[arr[end]]+1<=K){
                cnt[arr[end]]++;
                end++;
            }
            len = end-start;
            max = Math.max(max, len);
            cnt[arr[start]]--;
            start++;
        }
        System.out.println(max);
    }
}
