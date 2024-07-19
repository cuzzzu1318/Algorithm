package algorithm2024.jul.day13;

import java.io.*;
import java.util.*;

public class BOJ_10431_줄세우기 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int P;

    public static void main(String[] args) throws IOException {
        P = Integer.parseInt(br.readLine());
        for (int i = 0; i < P; i++) {
            st = new StringTokenizer(br.readLine());
            int T = Integer.parseInt(st.nextToken());
            int cnt =0;
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < 20; j++) {
                int n = Integer.parseInt(st.nextToken());
                if (list.isEmpty()) {
                    list.add(n);
                }else{
                    int idx = list.size()-1;
                    while (idx >= 0) {
                        if(list.get(idx)<=n){
                            break;
                        }
                        idx--;
                        cnt++;
                    }
                    list.add(idx+1,n);
                }

            }
            sb.append(T).append(" ").append(cnt).append("\n");
        }
        System.out.println(sb);
    }
}
