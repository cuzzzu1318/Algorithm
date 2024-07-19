package algorithm2024.jul.day14;

import java.io.*;
import java.util.*;

public class BOJ_9017_크로스컨트리 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();


    public static void main(String[] args) throws IOException {
        int T  = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            int[][] teams = new int[201][3];
            int[] rank = new int[N];
            for (int j = 0; j < N; j++) {
                int t = Integer.parseInt(st.nextToken());
                rank[j] = t;
                teams[t][0]++;
            }

            int[] count = new int[201];

            int score = 1;
            int min = Integer.MAX_VALUE;
            for (int p : rank) {
                if(teams[p][0]<6){
                    continue;
                }
                if(count[p]<4){
                    teams[p][1]+=score++;
                    count[p]++;
                    if(count[p]==4){
                        min = Math.min(min, teams[p][1]);
                    }
                }else if (count[p]==4){
                    teams[p][2]+=(teams[p][1]+score++);
                    count[p]++;
                }else{
                    score++;
                }
            }
            List<Integer> rankOne = new ArrayList<>();
            for (int j = 1; j < 201; j++) {
                if(teams[j][1]==min){
                    rankOne.add(j);
                }
            }
            if(rankOne.size()==1){
                sb.append(rankOne.get(0)).append("\n");
            }else{
                int min2 = Integer.MAX_VALUE;
                int winTeam = 0;
                for (Integer t : rankOne) {
                    if(teams[t][2]<min2){
                        min2 = teams[t][2];
                        winTeam = t;
                    }
                }
                sb.append(winTeam).append("\n");
            }
        }
        System.out.println(sb);
    }
}


//1 2 3 1 2 3 1 2 3 3 3 3 2 2 2 1 1 1
//1 2 3 4 5 6 7 8 9 0 1 2 3 4 5 6 7 8
//
//1 4 7 16 17 18
//2 5 8 13 14 15
//3 6 9 10 11 12