package algorithm2024.sep.day22;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_22251_빌런호석_bit {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int N, K, P, X;

    static int[] nums = {119, 18, 93, 91, 58, 107, 111, 82, 127, 123};


    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());


//        X를 숫자의 배열로 변경
        int[] floor = new int[K];
        for (int i = 0; i < K; i++) {
            floor[i] = X%(int)Math.pow(10, K-i)/(int)Math.pow(10, K-1-i);
        }

        int ans =0 ;
        for (int i = 1; i <= N; i++) {
//            각 자리별로 숫자들과 비교해보고 바꿔야 하는 LED 수가 P이하라면 카운트.
            if (i == X) continue;
            int cnt = 0;
            int idx = 0;
//            첫번째 자릿수부터 변경해야 하는 횟수 카운트
            for (int j = (int) Math.pow(10, K-1); j > 0; j/=10) {
                int n = i%(j*10)/j;
                cnt+=Integer.bitCount(nums[n]^nums[floor[idx]]);
                idx++;
            }
            if(cnt<=P) ans++;
        }
        System.out.println(ans);
    }
}
