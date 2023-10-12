package algorithm2023.oct.day12;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ_1708_볼록껍질 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int N;
	static Pos base;
	static ArrayList<Pos> pos = new ArrayList<>();

	static class Pos {
		long x, y;

		public Pos(long x, long y) {
			super();
			this.x = x;
			this.y = y;
		}

		@Override
		public String toString() {
			return "Pos [x=" + x + ", y=" + y + "]";
		}

	}

	public static void main(String[] args) throws Exception {

		N = Integer.parseInt(br.readLine());
		int minY = Integer.MAX_VALUE;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			long x = Long.parseLong(st.nextToken());
			long y = Long.parseLong(st.nextToken());
			pos.add(new Pos(x, y));
		}

		Collections.sort(pos, (o1, o2) -> {
			if (Long.compare(o1.y, o2.y)==0) {
				return Long.compare(o1.x, o2.x);
			}
			return Long.compare(o1.y, o2.y);
		});

		base = pos.get(0);
		pos.remove(0);

		Collections.sort(pos, (o1, o2) -> {
			return ccw(o1, base, o2);
		});

		ArrayDeque<Pos> stack = new ArrayDeque<>();
		stack.push(base);
		stack.push(pos.get(0));
		pos.remove(0);

		for (Pos p3 : pos) {
			while (stack.size() > 1) {
				Pos p2 = stack.pop();
				Pos p1 = stack.pop();
				double ret = ccw(p1, p2, p3);
				if (ret >0.0) {
					stack.push(p1);
					stack.push(p2);
					break;
				} else {
					stack.push(p1);
				}
			}
			stack.push(p3);
		}
		System.out.println(stack.size());
	}

	static double getDist(Pos p1, Pos p2) {
		return Math.sqrt((p1.x - p2.x) * (p1.x - p2.x) + (p1.y - p2.y) * (p1.y - p2.y));

	}

	static double getAngle(Pos p1, Pos p2) {
		long dy = p2.y - p1.y;
		long dx = p2.x - p1.x;

		double angle = Math.atan2(dy, dx);

		return angle;
	}

	// 음수면 시계
	// 양수면 반시계
	// 0이면 평행
	static int ccw(Pos p1, Pos p2, Pos p3) {
		long a = p1.x * p2.y + p2.x * p3.y + p3.x * p1.y;
		long b = p2.x * p1.y + p3.x * p2.y + p1.x * p3.y;

		long ret = a-b;
		if(ret<0) {
			return -1;
		}else if(ret>0) {
			return 1;
		}
		return 0;
	}
}
