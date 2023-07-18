package jul_2022;
import java.io.*;
import java.util.*;

public class BJ2480 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n1 = sc.nextInt();
		int n2 = sc.nextInt();
		int n3 = sc.nextInt();
		if(n1>6||n2>6||n3>6||n1<1||n2<1||n3<1) {
			System.out.println("Error!");
		}else {
			if(n1==n2&&n2==n3) {
				System.out.println((10000+n1*1000));
			}else if(n1==n2||n1==n3) {
				System.out.println((1000+n1*100));
			}else if(n2==n3) {
				System.out.println((1000+n2*100));
			}else {
				if(n1>n2&&n1>n3) {
					System.out.println((n1*100));
				}else if(n2>n1&&n2>n3) {
					System.out.println((n2*100));
				}else {
					System.out.println((n3*100));
				}
			}
		}
	}
}
