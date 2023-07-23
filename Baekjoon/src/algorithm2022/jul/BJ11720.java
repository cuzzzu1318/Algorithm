package algorithm2022.jul;
import java.io.*;
import java.util.*;

public class BJ11720 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		sc.nextLine();
		String str = sc.nextLine();
		int sum = 0;
		for(int i = 0;i<num;i++) {
			sum += str.charAt(i)-'0';
		}
		System.out.println(sum);
		
		
	}
}
