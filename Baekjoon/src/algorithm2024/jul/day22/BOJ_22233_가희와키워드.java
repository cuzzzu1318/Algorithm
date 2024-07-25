package algorithm2024.jul.day22;

import java.io.*;
import java.util.*;


public class BOJ_22233_가희와키워드 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashMap<String, Integer> keywords = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String keyword = br.readLine();
            keywords.put(keyword, keywords.getOrDefault(keyword, 0) + 1);
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), ",");
            while(st.hasMoreTokens()) {
                String word = st.nextToken();
                if(keywords.containsKey(word)) {
                    keywords.put(word, keywords.get(word) - 1);
                    if(keywords.get(word) == 0) {
                        keywords.remove(word);
                    }
                }
            }
            sb.append(keywords.size()).append("\n");
        }
        System.out.println(sb);
    }
}
