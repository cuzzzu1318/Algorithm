package nov_17;

/*
 * 난이도 : 
 * 아이디어: 
 * 시간복잡도:
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class SWEA2050 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] s = br.readLine().toCharArray();
		for(char c :s) {
			System.out.print(c-'A'+1+" ");
		}
	}
}