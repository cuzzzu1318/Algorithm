package algorithm2024.jan.day11;

import java.util.PriorityQueue;

public class PG_K번째수 {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = {};
        answer = new int[commands.length];

        for(int t = 0;t<commands.length;t++){
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            int i = commands[t][0];
            int j = commands[t][1];
            int k = commands[t][2];


            for(int idx = i-1;idx<j;idx++){
                pq.add(array[idx]);
            }

            for(int idx = 0;idx<k-1;idx++){
                pq.poll();
            }
            answer[t] = pq.poll();
        }

        return answer;
    }
}
