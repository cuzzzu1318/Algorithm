package algorithm2024.sep.day13;

import java.io.*;
import java.util.*;

public class BOJ_2531_회전초밥 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        // 초밥 저장할 배열
        ArrayList<Integer> list = new ArrayList<>();

        for(int i =0 ;i<N;i++){
            list.add(Integer.parseInt(br.readLine()));
        }

        Queue<Integer> q = new LinkedList<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        int max = 0;

        // 회전초밥이므로 리스트의 끝까지만 탐색하는 것이 아닌 k개를 추가로 탐색하면서 추가함.
        // 다음에 올 초밥을 추가하고 존재하는 초밥들을 Map에 저장하고 Map의 크기를 계산함으로써 중복된 초밥을 하나로 계산
        for(int i =0;i<N+k;i++){
            int newSushi = list.get(i%N);
            q.add(newSushi);
            map.put(newSushi, map.getOrDefault(newSushi, 0)+1);
            if(q.size()>k){
                int pollSushi = q.poll();
                if(map.get(pollSushi)>1){
                    map.put(pollSushi, map.get(pollSushi)-1);
                }else{
                    map.remove(pollSushi);
                }
            }
            int cnt = map.containsKey(c)?map.size():map.size()+1;
            max = Math.max(cnt, max);
        }
        System.out.println(max);

    }

}
