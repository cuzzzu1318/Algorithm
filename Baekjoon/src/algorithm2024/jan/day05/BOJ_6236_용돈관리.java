package algorithm2024.jan.day05;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_6236_용돈관리 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] cost = new int[N];
        int max = 0;
        for (int i = 0; i < N; i++) {
            cost[i] = Integer.parseInt(br.readLine());
            max = Math.max(max,cost[i]);
        }
        int lo = max;
        int hi = 2_000_000_000;

        while(lo<hi){
            int mid = (lo+hi)/2;
            int cnt = 0;
            int cur = 0;
            for (int i = 0; i < N; i++) {
                cur-=cost[i];
                if(cur<0){
                    cnt++;
                    cur = mid-cost[i];
                }
            }
//            System.out.println(lo+" "+hi+" "+mid+" "+cnt);
            if(cnt>M){
                lo = mid+1;
            }else{
                hi = mid;
            }
        }
        System.out.println(lo);
    }
}
