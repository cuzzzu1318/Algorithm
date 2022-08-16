package jul_18;
import java.io.*;
import java.util.*;

public class BJ2884 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int h = sc.nextInt();
		int m = sc.nextInt();
		if(h<0||h>23||m<0||m>59) {
			System.out.println("Error!");
		}else if(h>0&&m<45) {
			System.out.println(h-1+" "+(60-(45-m)));
		}else if(h==0&&m<45) {
			System.out.println("23 "+(60-(45-m)));
		}
		else {
			System.out.println(h+" "+(m-45));
		}
	}
}
