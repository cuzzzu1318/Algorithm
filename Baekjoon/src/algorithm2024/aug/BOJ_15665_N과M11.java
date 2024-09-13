package algorithm2024.aug;

import java.io.*;
import java.util.*;

public class BOJ_15665_N과M11{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        boolean[] booleans = new boolean[10001];
        st = new StringTokenizer(br.readLine());

        ArrayList<Integer> nums = new ArrayList<>();
        for(int i = 0; i<N;i++){
            int n = Integer.parseInt(st.nextToken());
            if(booleans[n])continue;
            booleans[n]=true;
            nums.add(n);
        }
        Collections.sort(nums);
        perm(0,0,new int[M], nums, N, M);
        System.out.println(sb);
    }

    static void perm(int src, int dst, int[] arr, ArrayList<Integer> nums,  int N, int M){
        if(dst==M){
            for (int i = 0; i < M; i++) {
                sb.append(arr[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 0; i < nums.size(); i++) {
            arr[dst]=nums.get(i);
            perm(i, dst+1, arr, nums, N, M);
        }

    }
}