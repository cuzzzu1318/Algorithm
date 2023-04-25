package april_2023;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;

public class S4_BOJ1920_0425 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws NumberFormatException, IOException {
		int N = Integer.parseInt(br.readLine());
		ArrayList<Integer> arr = new ArrayList<>();
		String[] s = br.readLine().split(" ");
		for (int i = 0; i < N; i++) {
			arr.add(Integer.parseInt(s[i]));
		}
		Collections.sort(arr);
		int M = Integer.parseInt(br.readLine());
		s = br.readLine().split(" ");
		for (int i = 0; i < M; i++) {
			int n = Integer.parseInt(s[i]);
			int max = arr.size() - 1;
			int min = 0;
			int middle = (min + max) / 2;
			boolean isContain = false;
			while (min <= max) {
				if (n > arr.get(middle)) {
					min = middle+1;
				} else if(n<arr.get(middle)){
					max = middle-1;
				}else {
					isContain = true;
					break;
				}
				
				middle = (min+max)/2;
			}
			if(isContain) {
				bw.write("1\n");
			}else {
				bw.write("0\n");
			}
		}
		bw.flush();
		bw.close();
	}
}