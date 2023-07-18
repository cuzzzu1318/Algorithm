package nov_2022;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Stack;

public class SWEA1859 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		LinkedList<Long> spentArr = new LinkedList<>();
		for (int i = 0; i < T; i++) {
			int N = Integer.parseInt(br.readLine());
			String[] s = br.readLine().split(" ");
			Stack<Integer> bucket = new Stack<>();
			long spent = 0;
			long cnt = 0;
			long max = 0;
			long maxVal = 0;
			for (int j = 0; j < N; j++) {
				bucket.push(Integer.parseInt(s[j]));
			}
			for (int j = 0; j < N; j++) {
				long last = bucket.pop();
				if(maxVal<last) {
					max+=cnt*maxVal;
					maxVal = last;
					cnt = 0;
				}else if(maxVal>last) {
					cnt++;
					spent+=last;
				}
				if(bucket.size()==0) {
					max+=cnt*maxVal;
				}
			}
			spentArr.add(max-spent);
		}
		int i = 1;
		for(long item: spentArr) {
			System.out.println("#"+(i++)+" "+item);
		}
	}
}
