package algorithm2024.jul.day22;

import java.io.*;
import java.util.*;

public class BOJ_3758_KCPC {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static class Team{
        int id, score;

        public Team(int id, int score) {
            this.id = id;
            this.score = score;
        }
    }

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            int id = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            int[][] scores = new int[n+1][k+1];
            int[] cnt = new int[n + 1];
            int[] lastSubmit = new int[n + 1];

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int curId = Integer.parseInt(st.nextToken());
                int curQ = Integer.parseInt(st.nextToken());
                int s = Integer.parseInt(st.nextToken());
                scores[curId][curQ] = Math.max(scores[curId][curQ], s);
                cnt[curId]++;
                lastSubmit[curId] = i;
            }

            List<Team> teams = new ArrayList<>();
            teams.add(new Team(0,0));
            for (int i = 1; i <= n; i++) {
                teams.add(new Team(i, 0));
                for(int j = 1;j<=k;j++){
                    teams.get(i).score+=scores[i][j];
                }
            }

            Collections.sort(teams, (o1,o2)->{
                if(o1.score == o2.score){
                    if(cnt[o1.id] == cnt[o2.id]){
                        return lastSubmit[o1.id]-lastSubmit[o2.id];
                    }
                    return cnt[o1.id]-cnt[o2.id];
                }
                return o2.score - o1.score;
            });
            int rank = 1;

            for (Team team : teams) {
                if (team.id == id) {
                    break;
                }
                if(team.id==0) continue;
                rank++;
            }
            sb.append(rank).append("\n");
        }
        System.out.println(sb);
    }
}
