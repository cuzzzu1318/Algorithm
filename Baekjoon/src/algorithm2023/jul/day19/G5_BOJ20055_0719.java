package algorithm2023.jul.day19;


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class G5_BOJ20055_0719{
	static int N;
	static int K;
	static int[] conv;
	static int up;
	static int down;
	static ArrayList<Integer> robot = new ArrayList<>();

	public static void main(String[] args) throws Exception {
		// System.setIn(new
		// FileInputStream("C:\\Users\\JH\\git\\Algorithm\\Baekjoon\\src\\input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		N = Integer.parseInt(s[0]);
		K = Integer.parseInt(s[1]);
		conv = new int[2 * N];
		robot = new ArrayList<>();
		up = 0;
		down = N - 1;
		s = br.readLine().split(" ");
		for (int i = 0; i < 2 * N; i++) {
			conv[i] = Integer.parseInt(s[i]);
		}

		int level = 1;

		while (true) {
			//회전(올리는위치, 내리는 위치 변경), 로봇이 있는 위치가 내리는위치가 된다면 로봇 내림.
			up--;
			down--;
			if (up < 0) {
				up = 2 * N - 1;
			}
			if (down < 0) {
				down = 2 * N - 1;
			}
			for (int i = 0; i < robot.size(); i++) {
				if (robot.get(i) == down) {
					robot.remove(i);
					break;
				}
			}
			
			//로봇 이동
			moveRobot();
			//올리는 위치의 내구도가 0 이상이라면 로봇 올림.
			if (conv[up] > 0) {
				robot.add(up);
				conv[up]--;
			}
			//내구도가 0인 칸의 개수가 K개 이상이라면 과정 종료
			if (isEnd()) {
				break;
			}
			level++;
		}
		System.out.println(level);
	}

	// 로봇 이동
	static void moveRobot() {
		//로봇의 인덱스가 저장된 배열 탐색
		for (int i = 0; i < robot.size(); i++) {
			//로봇의 다음 위치 n
			int n = robot.get(i) + 1;
			//다음 위치가 범위를 넘어서면 0으로 초기화
			if (n >= 2 * N)
				n = 0;
			//다음 위치에 로봇이 없고, 내구도가 남아있다면 로봇 이동 및 내구도 감소
			if (!robot.contains(n) && conv[n] > 0) {
				conv[n]--;
				if (n == down) {
					robot.remove(i);
					i--;
				} else {
					robot.set(i, n);
				}
			}

		}
	}

	static boolean isEnd() {
		int cnt = 0;
		for (int i : conv) {
			if (i <= 0) {
				cnt++;
			}
		}
		if (cnt >= K) {
			return true;
		} else {
			return false;
		}
	}
}