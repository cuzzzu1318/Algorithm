package algorithm2022.nov;

/* Knapsack ����, ���ǿ� ��ġ�� �־��� �� ������ ���� K�� ���� �ʵ��� �ִ� ��ġ�� ���
 * ���̵� : D3
 * ���̵��: 
 * �ð����⵵:
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class SWEA3282 {

	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			String[] s = br.readLine().split(" ");
			int N = Integer.parseInt(s[0]);
			int K = Integer.parseInt(s[1]);
			int[][] NK = new int[N+1][K+1];
			for(int i = 0;i<K;i++) {
				NK[0][i] = 0;
			}
			for(int i = 0;i<N;i++) {
				NK[i][0] = 0;
			}
			ArrayList<int[]> arr = new ArrayList<>();
			arr.add(new int[2]);
			for (int i = 0; i < N; i++) {
				int[] temp = new int[2];
				s = br.readLine().split(" ");
				temp[0] = Integer.parseInt(s[0]);
				temp[1] = Integer.parseInt(s[1]);
				arr.add(temp);
			}
			for(int[] a : arr) {
				//System.out.println(a[0]+" "+a[1]);
			}
			
			
			
			int max = 0;
			for(int i = 1;i<=N;i++) {
				for(int j = 1;j<=K;j++) {
					if(arr.get(i)[0]>j) {
						NK[i][j] = NK[i-1][j];
					}else {
						int Nput = NK[i-1][j];
						//System.out.println("arr.get(i): "+arr.get(i)[0]);
						//System.out.println(" "+NK[i-1][j-arr.get(i)[0]]);
						int put = arr.get(i)[1] + NK[i-1][j-arr.get(i)[0]];
						//System.out.println("i j: "+i+" "+j+" "+"Nput: "+Nput+" put: "+put);
						if(Nput>put) NK[i][j] = Nput; else NK[i][j] = put;
					}
					if(j==K) {
						if(NK[i][j]>max) max = NK[i][j];
					}
				}
			}
			System.out.println("#"+t+" "+max);

		}
	}
}