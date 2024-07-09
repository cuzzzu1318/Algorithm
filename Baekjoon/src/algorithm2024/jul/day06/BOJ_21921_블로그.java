package algorithm2024.jul.day06;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_21921_블로그 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int X, N;
    static int max = 0;

//    당일의 방문자를 저장하는 visitors, 해당일을 마지막으로 X일동안의 누적 방문자를 나타내는 memo
    static List<Integer> visitors = new ArrayList<Integer>();
    static int[] memo;


    public static void main (String[] args) throws Exception{
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        memo = new int[N+1];

        st = new StringTokenizer(br.readLine());
        //방문자가 0명인 0일차를 기록
        memo[0] = 0;
        visitors.add(0);

        //i일의 방문자를 입력받으며 해당 일을 기준으로 X일동안 몇명이 방문했는지 체크
        for (int i = 1; i <= N; i++) {
            int n = Integer.parseInt(st.nextToken());
            if (i < X) {
                memo[i] = n+memo[i-1];
            }else{
                memo[i] = memo[i-1]-visitors.get(i-X)+n;
            }
            max = Math.max(max, memo[i]);
            visitors.add(n);

        }

        //만약 최대 방문자가 0이면 "SAD" 출력, 아니라면 최대 방문자 수와 최대로 방문한 일 수를 출력
        if(max == 0){
            System.out.println("SAD");
        }else{
            int cnt = 0;
            for (int i : memo) {
                if(i == max){cnt++;}
            }
            sb.append(max).append("\n");
            sb.append(cnt);
            System.out.println(sb);
        }




    }
}
