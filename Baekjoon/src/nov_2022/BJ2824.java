package nov_2022;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.LinkedList;

public class BJ2824 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());  
		String[] s = br.readLine().split(" ");
		BigInteger A = new BigInteger("1");
		BigInteger B = new BigInteger("1");
		
		LinkedList<BigInteger> AList = new LinkedList<>();
		LinkedList<BigInteger> BList = new LinkedList<>();
		
		
		for(String num : s) {
			A = A.multiply(new BigInteger(num));
		}
		int M = Integer.parseInt(br.readLine());  
		s = br.readLine().split(" ");
		for(String num : s) {
			B = B.multiply(new BigInteger(num)) ;
		}
		
		String ans = A.gcd(B).toString(); //gcd�Լ��� �ִ����� ���ϱ�
		if(ans.length()>9) {
			ans=ans.substring(ans.length()-9);
		}
		
		System.out.println(ans);
		
		
	}
}
