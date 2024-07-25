package algorithm2024.jul.day24;

import java.io.*;
import java.util.*;

public class BOJ_1406_에디터 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        String s = br.readLine();
        int N = s.length();

        ArrayDeque<Character> lStack = new ArrayDeque<>();
        ArrayDeque<Character> rStack = new ArrayDeque<>();

        for (int i = 0; i < N; i++) {
            lStack.push(s.charAt(i));
        }

        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            String a = st.nextToken();
            switch (a) {
                case "L":
                    if(lStack.isEmpty()){
                        break;
                    }
                    rStack.push(lStack.pop());
                    break;
                case "D":
                    if(rStack.isEmpty()){
                        break;
                    }
                    lStack.push(rStack.pop());
                    break;
                case "B":
                    if(lStack.isEmpty()){
                        break;
                    }
                    lStack.pop();
                    break;
                case "P":
                    lStack.push(st.nextToken().charAt(0));
                    break;
            }
        }
        while (!lStack.isEmpty()) {
            sb.append(lStack.pollLast());
        }
        while(!rStack.isEmpty()) {
            sb.append(rStack.pop());
        }
        System.out.println(sb);
    }

}
