package algorithm2022.jul;
import java.io.*;
import java.util.*;

public class BJ9498 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int score = sc.nextInt();
		if(score>100||score<0) {
			System.out.println("Error!");
		}else if(score<=100&&score>=90) {
			System.out.println("A");
		}else if(score<=89&&score>=80) {
			System.out.println("B");
		}else if(score<=79&&score>=70) {
			System.out.println("C");
		}else if(score<=69&&score>=60) {
			System.out.println("D");
		}else {
			System.out.println("F");
		}
	}
}
