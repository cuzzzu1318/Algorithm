import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static boolean flag = false;
    static int N, K, ans;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        
        bfs(N,0);
        System.out.println(ans);
    }
    static void bfs(int temp, int cnt) {
    	System.out.println(temp);
        if(K == temp) {
            ans = cnt;
            flag = true;
        }
        if(flag) return;
        
        bfs(temp -1, cnt + 1);
        bfs(temp +1, cnt + 1);
        bfs(2*temp, cnt + 1);
    }
}