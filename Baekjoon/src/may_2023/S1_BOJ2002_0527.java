package may_2023;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class S1_BOJ2002_0527 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
		int N = Integer.parseInt(br.readLine());
		LinkedList<String> car = new LinkedList<>();
		//차의 수 N, 차를 저장할 리스트 car
		int cnt = 0;
		//카운트
		for (int i = 0; i < N; i++) {
			car.add(br.readLine());
		}
		//차가 들어온 순서
		
		
		for (int i = 0; i < N; i++) {
			String Exit = br.readLine();
			//나간 차
			if(!car.get(i).equals(Exit)) {
				//들어온 순서와 다르다면
				cnt++;
				car.add(i, car.remove(car.indexOf(Exit)));
				//추월한 것이므로 카운트 추가하고 인덱스 변경
			}
		}
		System.out.println(cnt);
	}
}