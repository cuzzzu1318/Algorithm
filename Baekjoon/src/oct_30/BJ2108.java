package oct_30;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BJ2108 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		ArrayList<Integer> arr = new ArrayList<>();
		for(int i = 0;i<N;i++) {
			arr.add(Integer.parseInt(br.readLine()));
		}
		int sum = 0;
		double avg;
		int mode;
		int range;
		arr.sort(null);
		for(int n : arr) {
			sum+=n;
		}
		avg = sum/N;
		mode = arr.get(N/2);
		range = arr.get(N-1)-arr.get(0);
	}
}
