package algorithm2022.jul;
import java.io.*;
import java.util.*;

public class BJ2525 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int h = sc.nextInt();
		int m = sc.nextInt();
		int time = sc.nextInt();
		if(h<0||h>23||m<0||m>59) {
			System.out.println("Error!");
		}else {
			int sum = h*60 + m + time;
			if(sum>=1440) {
				sum -= 1440;
			}
			h = sum/60;
			m = sum%60;
			System.out.println(h+" "+m);
		}
	}
}
