package algorithm2024.jul.day19;

import java.io.*;
import java.util.*;

public class BOJ_19941_햄버거분배 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int N,K;
    static char[] arr;
    static boolean[] v;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new char[N];
        v = new boolean[N];
        String s = br.readLine();
        for (int i = 0; i < N; i++) {
            arr[i] = s.charAt(i);
        }

        int ans = 0;
//      순회하면서 사람을 찾고, 사람이면 K범위 내에 햄버거 있으면 바로 먹기
//      왼쪽을 먼저 봐야 함. 오른쪽 걸 먹으면 오른쪽 사람이 못먹는 경우가 생길 수 있음.
        for (int i = 0; i < N; i++) {
            if(arr[i] == 'P'){
//                System.out.print(i+"번째 사람이 ");
                boolean eatFlag = false;
                int start = Math.max(i - K, 0);

                for (int j = start; j <i; j++) {
                    if(arr[j]=='H'&&!v[j]){
//                        System.out.println(j+"번째 햄버거 먹음.");
                        v[j] = true;
                        eatFlag = true;
                        ans++;
                        break;
                    }
                }
                if(!eatFlag){
                    for (int j = i + 1; j < N; j++) {
                        if(j>i+K){
//                            System.out.println("못먹음.");
                            break;
                        }
                        if(arr[j]=='H'&&!v[j]){
//                            System.out.println(j+"번째 햄버거 먹음.");
                            v[j] = true;
                            ans++;
                            break;
                        }
                    }
                }
            }
        }

        System.out.println(ans);

    }
}
