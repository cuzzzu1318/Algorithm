package algorithm2024.jul.day13;

import java.io.*;
import java.util.*;

public class BOJ_20125_쿠키의신체측정 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int N;
    static String[][] map;
    static boolean[][] v;

    static int[] dy = {1,0};
    static int[] dx = {0,1};

    static class Point{
        int y,x;

        public Point(int y, int x) {
            this.y = y;
            this.x = x;
        }

        @Override
        public String toString() {
            return "Point{" +
                    "y=" + y +
                    ", x=" + x +
                    '}';
        }
    }
    static boolean isValid(int y, int x){
        return y >= 0 && y < N && x >= 0 && x < N;
    }
    public static void main(String[] args) throws Exception {
        N = Integer.parseInt(br.readLine());
        map = new String[N][N];
        v = new boolean[N][N];

        Point heart = new Point(0, 0);
        boolean findHeart = false;

        for (int i = 0; i < N; i++) {
            String[] s = br.readLine().split("");
            for (int j = 0; j < N; j++) {
                map[i][j] = s[j];
                if(s[j].equals("*")&& !findHeart){
                    heart = new Point(i+1, j);
                    findHeart = true;
                }
            }
        }
        int leftArm =0;
        int rightArm = 0;
        int waist =0;
        int leftLeg = 0;
        int rightLeg = 0;

        for(int i = heart.x-1;i>=0;i--){
            if(map[heart.y][i].equals("_"))break;
            leftArm++;
        }
        for(int i = heart.x+1;i<N;i++){
            if(map[heart.y][i].equals("_"))break;
            rightArm++;
        }
        for(int i =heart.y+1;i<N;i++){
            if(map[i][heart.x].equals("_")){
                for (int j = i; j < N; j++) {
                    if(map[j][heart.x-1].equals("_")){break;}
                    leftLeg++;
                }
                for (int j = i; j < N; j++) {
                    if(map[j][heart.x+1].equals("_")){break;}
                    rightLeg++;
                }

                break;
            }
            waist++;
        }


        heart.y++;
        heart.x++;
        System.out.println(heart.y+" "+heart.x);
        System.out.println(leftArm+" "+rightArm+" "+waist+" "+leftLeg+" "+rightLeg);

    }
}
