package april_2023;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;

public class S5_BOJ1181_0425 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws NumberFormatException, IOException {
		int N = Integer.parseInt(br.readLine());
		ArrayList<ArrayList<String>> arr = new ArrayList<>();
		int maxlen = 0;
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			if(s.length()>maxlen) {
				ArrayList<String> temp = new ArrayList<>();
				temp.add(s);
				arr.add(temp);
				maxlen = s.length();
			}
			for (int j = 0; j < arr.size(); j++) {
				if (arr.get(j).get(0).length() == s.length()) {
					if (!arr.get(j).contains(s)) {
						arr.get(j).add(s);
					}
					break;
				}else if(arr.get(j).get(0).length() > s.length()) {
					ArrayList<String> temp = new ArrayList<>();
					temp.add(s);
					arr.add(j,temp);
					break;
				}
			}
		}
		for(ArrayList<String> a : arr) {
			Collections.sort(a);
			for(String c : a) {
				bw.write(c+"\n");
			}}
		bw.flush();
		bw.close();
	}
}