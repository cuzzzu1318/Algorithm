package algorithm2023.mar;

/*  N���� ���� �� ù��° ���ڰ� ������ ���ں��� Ŀ���� ���� ������ ���ڿ��� �󸶸� �����;� �ϴ°�?
 * ���̵� : �ǹ� 5
 * ���̵��: 
 * �ð����⵵:
 * �ҿ� �ð�: 10:37~
 * */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class S5_BOJ1417_0315 {

	static int N;
	static ArrayList<Integer> arr = new ArrayList<>();
	static int ans = 0;

	static int maxIdx(ArrayList<Integer> arr) {
		//System.out.println(arr);
		int max = 0;
		int maxIndex = 0;
		for (int i = 0; i < arr.size(); i++) {
			if (arr.get(i) >= max) {
				max = arr.get(i);
				maxIndex = i;
			}
		}
		if (maxIndex == 0) {
			return 0;
		}
		return maxIndex;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		int max = 0;
		for (int i = 0; i < N; i++) {
			int n = Integer.parseInt(br.readLine());
			if (n > max) {
				max = n;
			}
			arr.add(n);
		}
		//System.out.println(arr);
		int i = 1;
		while (true) {
			int n = maxIdx(arr);
			if(n==0) {
				break;
			}
			if(arr.get(n)>=arr.get(0)) {
				arr.set(n, arr.get(n)-1);
				arr.set(0, arr.get(0)+1);
				ans++;
			}
			
		}
		bw.write(Integer.toString(ans));
		bw.flush();
		bw.close();

	}
}