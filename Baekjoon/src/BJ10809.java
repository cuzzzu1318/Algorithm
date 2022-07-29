import java.io.*;
import java.util.*;

public class BJ10809 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String word = sc.nextLine();
		word = word.toLowerCase();
		int n = 97;
		for(int i = 0;i<26;i++) {
			System.out.print(word.indexOf(n)+" ");
			n++;
		}
		
	}
}
