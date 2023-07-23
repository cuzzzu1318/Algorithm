package algorithm2023.mar;

/*  �ܾ��� ���� �迭�� ����� �� ã��. ���� ���ڰ� �ƿ� ���ų� �Ѱ� ������ ��찡 ����� ���
 * ���̵� : �ǹ� 3
 * ���̵��: �ܼ� ��
 * �ð����⵵:
 * �ҿ� �ð�: 13:30~ 14:25 ( 55min )
 * */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class S3_BOJ2607_0318 {

	static int N;
	static String str;
	
	static boolean isSimilar(String s) {
		ArrayList<Character> v = new ArrayList<>();
		int freq = 0;
		for(int i = 0;i<str.length();i++) {
			if(v.contains(str.charAt(i))) {
				continue;
			}
			v.add(str.charAt(i));
			int freq1 = 0;
			int freq2 = 0;
			for(int j = 0;j<str.length();j++) {
				if(str.charAt(i)==str.charAt(j)) {
					freq1++;
				}
			}
			for(int j = 0;j<s.length();j++) {
				if(str.charAt(i)==s.charAt(j)) {
					freq2++;
				}
			}
			freq += Math.min(freq1, freq2);
		}
		//System.out.println(s);
		//System.out.println(freq);
		int leng = Math.max(str.length(), s.length());
		if(freq==leng+1||freq==leng||freq==leng-1) {
			return true;
		}
		return false;
	}
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
      N= Integer.parseInt(br.readLine());
      str = br.readLine();
      ArrayList<String> arr = new ArrayList<>();
      int ans = 0;
      for(int i = 0;i<N-1;i++) {
    	 if(isSimilar(br.readLine())) {
    		 ans++;
    	 }
      }
      bw.write(Integer.toString(ans));
      bw.flush();
      bw.close();
      
   }
}