import java.io.*;
import java.util.*;

public class BJ4673 {
	
	public static void SelfNum() {
		ArrayList<Integer> notSN = new ArrayList<Integer>();
		int lastNum = 0;
		for(int i = 1;i<=10000;i++) {
			int num = i + i/10000 + i%10000/1000 + i%1000/100 + i%100/10 + i%10;
			lastNum = num;
			notSN.add(num);
		}
		for(int i = 1; i <=10000; i++) {
			if(notSN.contains(i)==false) {
				System.out.println(i);
			}
		}
	}
	
	public static void main(String[] args) {
		SelfNum();
	}
}
