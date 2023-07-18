package nov_2022;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class SWEA2072 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		LinkedList<Integer> sumArr = new LinkedList<>();
		for(int i = 0;i<T;i++) {
			String[] s = br.readLine().split(" ");
			int sum = 0;
			for(int j=0;j<10;j++) {
				if(Integer.parseInt(s[j])%2==1) {
					sum+=Integer.parseInt(s[j]);
				}
			}
			sumArr.add(sum);
		}
		int i = 1;
		for(int item : sumArr) {
			System.out.println("#"+(i++)+" "+item);
		}
	}
}
