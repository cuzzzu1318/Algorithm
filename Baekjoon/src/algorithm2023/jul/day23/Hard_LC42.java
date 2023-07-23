package algorithm2023.jul.day23;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Hard_LC42 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String[] s = br.readLine().substring(10).split("\\[|,|\\]");
		System.out.println(Arrays.toString(s));
	}

}
