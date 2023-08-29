import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static boolean flag = false;
    static int N, K, ans;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int[] f = new int[100];
        f[0] = 1;
        f[1] = 2;
        for(int i= 2;i<100;i++) {
        	f[i] = f[i-1]*2+f[i-2];
        }
        System.out.println(f[6]);
    }
}