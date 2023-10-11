import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            int N = Integer.parseInt(br.readLine());
            int[] point = new int[N];
            int max = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            point[0] = Math.abs(x) + Math.abs(y);
            boolean fail = false;
            for (int i = 1; i < N; i++) {
                 st = new StringTokenizer(br.readLine());
                x = Integer.parseInt(st.nextToken());
                y = Integer.parseInt(st.nextToken());
                point[i] = Math.abs(x) + Math.abs(y);
                if(point[i]%2!=point[i-1]%2)fail = true;
                
                max = Math.max(max, point[i]);
            }

            
            
            if (fail) {
            	sb.append("#").append(t).append(" ").append(-1).append("\n");
            	continue;// 모이지 못한다
            }

            int turn = 0;
            while (true) {
                boolean stop = true;
                int m = max - turn;

                if (m > 0) {
                    max -= turn;
                } else {
                    m = Math.abs(m);
                    if (m % 2 == 1)// 홀수
                        max = 1;// 0까지 까고 왔다갔다 하고싶은데
                    else// 짝수면 0
                        max = 0;
                }
                if (max != 0) {
                    stop = false;
                }
                if (stop)
                    break;
                turn++;
            }
            sb.append("#").append(t).append(" ").append(turn).append("\n");
        }
        System.out.println(sb);
    }
}

