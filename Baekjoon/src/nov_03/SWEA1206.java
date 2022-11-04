package nov_03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;

public class SWEA1206 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		LinkedList<Integer> ansArr = new LinkedList<>();
		for (int i = 0; i < 10; i++) {
			int N = Integer.parseInt(br.readLine());
			LinkedList<Integer> buildings = new LinkedList<>();
			int sum = 0;
			String[] s = br.readLine().split(" ");
			for(String st : s) {
				buildings.add(Integer.parseInt(st));
			}
			for(int j = 2;j<N-2;j++) {
				int[] arr = new int[3];
				int[] arr2 = new int[3];
				for(int k = -2;k<1;k++) {
					arr[k+2] = buildings.get(j+k);
				}
				for(int k = 0;k<3;k++) {
					arr2[k] = buildings.get(j+k);
				}
				Arrays.sort(arr);
				Arrays.sort(arr2);
				int cur = buildings.get(j);
				if(arr[2]==cur&&arr2[2]==cur) {
					if(arr[1]>arr2[1]) {
						sum+= cur-arr[1];
					}else {
						sum+=cur-arr2[1];
					}
				}
			}
			ansArr.add(sum);
		}
		int i =1;
		for(int item:ansArr) {
			System.out.println("#"+i+++" "+item);
		}
	}
}