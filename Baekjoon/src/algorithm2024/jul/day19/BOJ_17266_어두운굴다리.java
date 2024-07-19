package algorithm2024.jul.day19;

import java.io.*;
import java.util.*;

public class BOJ_17266_어두운굴다리 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int N, M;
    static int[] lamps;


    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        lamps = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            lamps[i] = Integer.parseInt(st.nextToken());
        }
        int ans = lamps[0];
        int cur = lamps[0];

        for (int i = 1; i < M; i++) {
            if(lamps[i]-cur>(2*ans)){
                if((lamps[i]-cur)%2==0){
                    ans = (lamps[i]-cur)/2;
                }else {
                    ans = (lamps[i] - cur)/2+1;
                }
            }
            cur = lamps[i];
        }
        if(N-lamps[M-1]>ans){
            ans = N-lamps[M-1];
        }
        System.out.println(ans);
    }
}
