package algorithm2022.nov;

/*
 * ���̵� : 
 * ���̵��: 
 * �ð����⵵:
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class SWEA1225 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= 10; t++) {
			int n = Integer.parseInt(br.readLine());
			Queue<Integer> pt = new LinkedList<>();
			String[] s = br.readLine().split(" ");
			for (String str : s) {
				pt.add(Integer.parseInt(str));
			}
			boolean go = true;
			while (go) {
				
				for (int i = 1; i <= 5; i++) {
					int num = pt.poll()-i;
					if(num<=0) {
						pt.add(0);
						go=false;
						break;
					}
					pt.add(num);
				}
			}
			System.out.print("#"+n+" ");
			for(int item : pt) {
				System.out.print(item+" ");
			}
			System.out.println("");
		}
	}
}