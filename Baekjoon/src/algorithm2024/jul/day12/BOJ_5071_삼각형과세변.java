package algorithm2024.jul.day12;

import java.io.*;
import java.util.*;

public class BOJ_5071_삼각형과세변 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int[] arr = new int[3];

    public static void main(String[] args) throws Exception{
        while (true) {
            st = new StringTokenizer(br.readLine());
            arr[0] = Integer.parseInt(st.nextToken());
            arr[1] = Integer.parseInt(st.nextToken());
            arr[2] = Integer.parseInt(st.nextToken());
            if(arr[0]==0 && arr[1]==0 && arr[2]==0) {break;}
            Arrays.sort(arr);

            if(arr[2]==arr[1]){
                if (arr[1] == arr[0]) {
                    System.out.println("Equilateral");
                }else{
                    System.out.println("Isosceles");
                }

            }else{
                if(arr[2]>=arr[1]+arr[0]){
                    System.out.println("Invalid");
                    continue;
                }
                if(arr[1]==arr[0]){
                    System.out.println("Isosceles");
                }else{
                    System.out.println("Scalene");
                }
            }

        }

    }

}
