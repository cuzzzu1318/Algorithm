import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();


	public static void main(String[] args) throws Exception {
		Random random = new Random();
		int n = random.nextInt(3);
		int[] rand = {6,8,10};
		System.out.println("문제 갯수: "+rand[n]);
		boolean[] v = new boolean[77];
		for (int i = 0; i < rand[n]; i++) {
			int randomNumber =  random.nextInt(76)+1;
			if(v[randomNumber]) {
				System.out.println("중복: "+randomNumber);
				i--;
				continue;
			}
			v[randomNumber] = true;
//			System.out.println("성완 정호 창희 재원");
			System.out.println("문제 번호: "+randomNumber);
		}


//		1~28 자료구조 알고리즘
//		29~44 네트워크
//		45~60 디자인패턴 프로그래밍 패러다임
//		61~76 데이터베이스





//		문제 갯수: 6

//		문제 번호: 20
//		문제 번호: 28
//		문제 번호: 24
//		문제 번호: 66
//		문제 번호: 11
//		문제 번호: 43
	}

}