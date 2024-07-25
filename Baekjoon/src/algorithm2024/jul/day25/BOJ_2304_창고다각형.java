package algorithm2024.jul.day25;

import java.io.*;
import java.util.*;

public class BOJ_2304_창고다각형 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static class Pillar{
        int L;
        int H;

        public Pillar(int l, int h) {
            L = l;
            H = h;
        }
    }

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());

        Pillar[] pillars = new Pillar[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int L  = Integer.parseInt(st.nextToken());
            int H = Integer.parseInt(st.nextToken());
            pillars[i] = new Pillar(L, H);
        }

        Arrays.sort(pillars, (o1,o2)->{
            return o1.L-o2.L;
        });

        int leftL = pillars[0].L;
        int leftH = pillars[0].H;

        int ans =0;

        for (int i = 1; i < N; i++) {
            //높이가 이전꺼보다 높으면 (현재 위치 - 이전 위치)*이전 높이 만큼 면적 +
            int L = pillars[i].L;
            int H = pillars[i].H;
            if(H>leftH){
                ans+=(L-leftL)*leftH;
                leftH = H;
                leftL = L;
            }
        }

        int rightL = pillars[N-1].L;
        int rightH = pillars[N-1].H;
        for(int i = N-1;i>=0;i--){
            int L = pillars[i].L;
            int H = pillars[i].H;
            if(H>rightH){
                ans+=(rightL-L)*rightH;
                rightH = H;
                rightL = L;
            }
        }

        if(leftH==rightH&&leftL<rightL){
            ans+=(rightL-leftL+1)*leftH;
        }else{
            ans+=leftH;
        }
        System.out.println(ans);


    }
}
