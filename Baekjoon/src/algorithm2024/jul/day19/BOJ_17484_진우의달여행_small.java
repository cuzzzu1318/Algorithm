package algorithm2024.jul.day19;

import java.io.*;
import java.util.*;


public class BOJ_17484_진우의달여행_small {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int N,M;
    static int[][] map;
    static int[][][] v;

    static int min = Integer.MAX_VALUE;

    static int[] dx = {-1,0,1};

    static class Point{
        int y;
        int x;
        int cost;
        int prevD;

        public Point(int y, int x, int cost, int prevD) {
            this.y = y;
            this.x = x;
            this.cost = cost;
            this.prevD = prevD;
        }
    }

    static boolean isValid(int y, int x){
        return y >= 0 && y < N && x >= 0 && x < M;
    }

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        v = new int[N][M][3];
        for(int i =0 ;i<N;i++){
            for(int j =0 ;j<M;j++){
                Arrays.fill(v[i][j],Integer.MAX_VALUE);
            }
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < M; i++) {
            Point start = new Point(0,i, map[0][i], -1);
            Queue<Point> q = new LinkedList<>(); 
            q.offer(start);
            while (!q.isEmpty()) {
                Point curr = q.poll();
                for(int d = 0;d<3;d++){
                    if(d==curr.prevD)continue;
                    int ny = curr.y+1;
                    int nx = curr.x+dx[d];
                    if(!isValid(ny,nx)){
                        continue;
                    }
                    int next = curr.cost+map[ny][nx];
                    if(v[ny][nx][d]>next){
                        v[ny][nx][d] = next;
                        q.offer(new Point(ny,nx,next,d));
                    }
                }
            }
        }
        for(int i =0 ;i<M;i++){
            for(int j = 0;j<3;j++){
                min = Math.min(min,v[N-1][i][j]);
            }
        }
        System.out.println(min);
    }
}
