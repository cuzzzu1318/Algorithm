package may_2023;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class G5_BOJ5430_0511 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
		int T = Integer.parseInt(br.readLine());
		loop: for (int t = 0; t < T; t++) {
			String[] p = br.readLine().split("");
			//명령어 배열
			int n = Integer.parseInt(br.readLine());
			//배열에 있는 초기값의 개수
			int[] arr = new int[n];
			String[] s = br.readLine().replace("[", "").replace("]", "").split(",");
			//"[", ",", "]"를 뺀 배열의 요소만 저장
			for (int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(s[i]);
			}
			int start = 0;
			//시작 인덱스
			int end = n - 1;
			//마지막 인덱스
			boolean isReverse = false;
			//배열이 뒤집혔는지 확인할 변수
			for (int i = 0; i < p.length; i++) {
				//명령어를 확인
				if (p[i].equals("R")) {
					//R이면 배열의 시작 인덱스와 마지막 인덱스 스왑하고 isReverse 변경
					int temp = end;
					end = start;
					start = temp;
					isReverse = !isReverse;
				} else {
					if (isReverse) {
						if (start < end) {
							//뒤집힌 상태인데 시작 인덱스가 더 작으면 탐색할 수 없으므로 에러
							sb.append("error\n");
							continue loop;
						}
						///에러가 아니라면 시작 인덱스 줄이기 -> 뒤집힌 상태이므로 오른쪽에서 원소를 버리기 위해 줄여줌
						start--;
					} else {
						if (start > end) {
							//뒤집히지 않았는데 시작 인덱스가 더 크면 탐색할 수 없으므로 에러
							sb.append("error\n");
							continue loop;
						}
						//에러가 아니라면 시작 인덱스 ++
						start++;
					}
				}
			}

			sb.append("[");
			//뒤집힌 상태와 아닌 상태 구분하여 순방향 / 역방향 출력
			if (isReverse) {
				for (int i = start; i >= end; i--) {
					sb.append(arr[i]);
					if(i!=end) {
						sb.append(",");
					}
				}
			} else {
				for(int i= start;i<=end;i++) {
					sb.append(arr[i]);
					if(i!=end) {
						sb.append(",");
					}
				}
			}
			sb.append("]\n");
		}
		System.out.println(sb);
	}
}