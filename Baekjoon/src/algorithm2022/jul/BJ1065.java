package algorithm2022.jul;
import java.io.*;
import java.util.*;

public class BJ1065 {
	
	public static int Hansoo(int num) {
		int cnt = 0;
		if(num>1000||num<0) {
			System.out.println("0<num<1000 �̳��� ���� �Է����ּ���.");
		}else {
			for(int i = 1;i<=num;i++) {
				if(i<10) {
					cnt++;
				}else if(i>=10&&i<100) {
					cnt++;
				}else if(i>=100&&i<1000) {
					if(i/100 -  i%100/10== i%100/10 - i%10) {
						cnt++;
					}
				}
			}
		}
		return cnt;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println(Hansoo(sc.nextInt()));
		
	}
}
