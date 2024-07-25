package algorithm2024.jul.day22;

import java.io.*;
import java.util.*;

public class BOJ_19637_IF문좀대신써줘 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static class Title{
        String name;
        int score;

        public Title(String name, int score) {
            this.name = name;
            this.score = score;
        }
    }

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<Title> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int score = Integer.parseInt(st.nextToken());
            list.add(new Title(name, score));
        }

        for (int i = 0; i < M; i++) {
            int score = Integer.parseInt(br.readLine());
            int lo = 0;
            int hi = N-1;
            while(lo<hi){
                int mid = (lo+hi)/2;
                if(list.get(mid).score<score){
                    lo = mid+1;
                }
                else{
                    hi = mid;
                }
            }
            sb.append(list.get(lo).name).append("\n");
        }

        System.out.println(sb);
    }
}
