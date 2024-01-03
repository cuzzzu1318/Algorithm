package algorithm2024.jan.day03;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2343_기타레슨 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int N, M, lecture[];
    public static void main(String[] args) throws Exception{
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        lecture = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            lecture[i] = Integer.parseInt(st.nextToken());
        }
        int lo = 1;
        int hi = N*10000+1;
        while(lo<hi){
            int mid = (lo + hi) / 2;
            int sum = 0;
            int cnt = 1;
            boolean isBig = false;
            for (int i : lecture) {
                if(i>mid){
                    isBig = true;
                    break;
                }
                sum+=i;
                if(sum>mid){
                    cnt++;
                    sum=i;
                }
            }
            if(cnt>M||isBig){
                lo = mid+1;
            }else{
                hi = mid;
            }
        }
        sb.append(hi);
        System.out.println(sb);
    }
}
