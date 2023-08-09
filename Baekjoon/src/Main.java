import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        
        Long[] start_time = new Long[N];
        Long[] end_time = new Long[N];
        boolean[] the_end = new boolean[N];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            st.nextToken();
            start_time[i] = Long.parseLong(st.nextToken());
            end_time[i] = Long.parseLong(st.nextToken());
        }
        
        Arrays.sort(start_time);
        Arrays.sort(end_time);
        int cnt = 0;
        int max = 0;
        int end_idx = 0;
        for(int i = 0; i < N; i++) {
            Long now = start_time[i];
            cnt++;
            
            
            for(int j = i-1; j >= end_idx; j--) {
                if(now >= end_time[j] && !the_end[j]) {
                    the_end[j] = true;
                    cnt--;
                    end_idx++;
                }
            }
            if(cnt > max) max = cnt;
        }
        System.out.println(max);
        
    }

}