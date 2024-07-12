package algorithm2024.jul.day12;

import java.io.*;
import java.util.*;

public class BOJ_9655_돌게임 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int N;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        if(N%2==0){
            System.out.println("CY");
        }else{
            System.out.println("SK");
        }
    }
}
