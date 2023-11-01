package algorithm2023.nov.day01;

import java.util.*;
import java.io.*;

public class Main_20056_마법사상어와파이어볼 {

    private static int N, M, K, result;
    private static List<Ball>[][] map;
    private final static int[][] delta = {{-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}};


    private static void selectMove() {

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!map[i][j].isEmpty()) {   // 해당 칸에 파이어볼이 존재하면
                    for (Ball fire : map[i][j]) {  // 칸에 있는 모든 볼을 move
                    	if(fire.isMove) {
                    		continue;
                    	}
                        move(i, j, fire);
                    }
                    map[i][j].clear();
                }
            }
        }

        ballCount();    // 모든 칸의 파이어볼 이동이 끝나면 각 칸을 검사한다
    }

    private static void move(int x, int y, Ball fire) {

        for (int i = 0; i < fire.s; i++) {
            int nx = x + delta[fire.d][0];
            int ny = y + delta[fire.d][1];

            if (nx < 0) nx += N;
            else if (nx >= N) nx -= N;
            if (ny < 0) ny += N;
            else if (ny >= N) ny -= N;

            x = nx;
            y = ny;
        }
        Ball b = new Ball(fire.m,fire.s,fire.d);
        b.isMove = true;
        map[x][y].add(b);
        
    }

    private static void ballCount() {

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j].size() > 1) {
                    // System.out.println(i+ ", "+j);
                    ballComb(i, j); // 칸에 있는 파이어볼이 2개 이상이면 볼을 합침
                }
            }
        }
    }

    private static void ballComb(int x, int y) {

        int mSum = 0, sSum = 0, dir = 1;
        boolean even=true, odd=true;

        for (Ball ball : map[x][y]) {
            mSum += ball.m;
            sSum += ball.s;
            if(ball.d%2==0){
                odd=false;
            } else{
                even=false;
            }
        }

        mSum = mSum / 5;
        sSum = sSum / map[x][y].size();

        if(odd||even) dir = 0;  // 모든 값이 홀수 또는 짝수라면 방향 시작 값을 0으로 변경

        map[x][y].clear();  // 원래 존재하는 모든 공은 없애 준다.

        if (mSum == 0) return;  // 질량이 0이라면 함수 실행 X; return

        for (int i = 0; i < 4; i++) {
            map[x][y].add(new Ball(mSum, sSum, dir));   // 새로운 공 4개 추가
            dir += 2;
        }
    }

    private static void mass() {

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!map[i][j].isEmpty()) {
                    for (Ball b : map[i][j]) {
                        result += b.m;
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        result = 0;

        map = new ArrayList[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = new ArrayList<>();
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            int m = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            map[x][y].add(new Ball(m, s, d));
        }

        for (int i = 0; i < K; i++) {
            selectMove();
        }

        mass();

        System.out.println(result);

    }

    static class Ball {
        int m, s, d; // 질량, 속력, 방향
        boolean isMove = false;;

        public Ball(int m, int s, int d) {
            this.m = m;
            this.s = s;
            this.d = d;
        }

        @Override
        public String toString() {
            return "[" + m + ", " + s + ", " + d + "]";
        }
    }

}
