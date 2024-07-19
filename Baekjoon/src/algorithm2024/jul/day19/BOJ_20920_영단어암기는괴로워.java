package algorithm2024.jul.day19;

import java.io.*;
import java.util.*;

public class BOJ_20920_영단어암기는괴로워 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int N,M;
    static HashMap<String, Integer> map = new HashMap();
    static List<String> words = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            if(s.length()<M){
                continue;
            }
            if(map.containsKey(s)){
                map.put(s, map.get(s)+1);
            }else{
                map.put(s,1);
                words.add(s);
            }
        }

        Collections.sort(words, (o1,o2)->{
            if(map.get(o1).equals(map.get(o2))){
                if(o1.length()==o2.length()){
                    return o1.compareTo(o2);
                }
                return o2.length()-o1.length();
            }
            return map.get(o2)-map.get(o1);
        });
        for (String word : words) {
            sb.append(word).append("\n");
        }
        System.out.println(sb);
    }

}
