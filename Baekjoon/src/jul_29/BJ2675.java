package jul_29;
import java.io.*;
import java.util.*;

public class BJ2675 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt();
		sc.nextLine();
		ArrayList<String> arr = new ArrayList<String>();
		for(int i = 0;i<testCase;i++) {
			String str = sc.nextLine();
			String[] list = str.split(" ");
			int R = Integer.parseInt(list[0]);
			String S = list[1];
			String P = "";
			for(int j = 0;j<S.length();j++) {
				for(int k = 0;k<R;k++) {
					P+= S.charAt(j);
				}
			}
			arr.add(P);
		}
		for(String p : arr) {
			System.out.println(p);
		}
		
		
		
	}
}
