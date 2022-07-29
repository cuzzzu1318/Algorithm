import java.io.*;
import java.util.*;

public class BJ1157 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String word = sc.nextLine();
		word = word.toLowerCase();
		int arr[] = new int[26];
		Arrays.fill(arr, 0);
		for(int i = 0; i<word.length();i++) {
			arr[word.charAt(i)-96]++;
		}
		char max;
		for(int i = 0; i<25;i++) {
			if(arr[i]>arr[i+1]) {
				max = i;
			}
		}
		
		
		
		
	}
}
