package algorithm2022.nov;

/* �α��� �ܹ��� ��ȣ��, dp����
 * ���̵� : D3
 * ���̵��: dp�� �̿��Ѵ�.
 * �ð����⵵:
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class SWEA5215 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			String[] str = br.readLine().split(" ");
			int N = Integer.parseInt(str[0]);
			int L = Integer.parseInt(str[1]);
			ArrayList<int[]> arr = new ArrayList<>();
			ArrayList<ArrayList<int[]>> d = new ArrayList<>();
			ArrayList<Integer> ans = new ArrayList<>();
			for (int i = 0; i < N; i++) {
				int[] a = new int[2];
				str = br.readLine().split(" ");
				a[0] = Integer.parseInt(str[0]);
				a[1] = Integer.parseInt(str[1]);
				arr.add(a);
				ArrayList<int[]> b = new ArrayList<>();
				b.add(a);
				d.add(b);
			}
			for(int i =1;i<N;i++) {
				
				for(int j=0;j<i;j++) {
					for(int[] a : d.get(j)) {
						if(a[1]+arr.get(i)[1]<=L) {
							int[] temp = new int[2];
							temp[0] = a[0]+arr.get(i)[0];
							temp[1] = a[1]+arr.get(i)[1];
							d.get(i).add(temp);
							ans.add(temp[0]);
						}
					}
				}
			}
			Collections.sort(ans);
			System.out.println("#"+t+" "+ans.get(ans.size()-1));

		}
	}
}