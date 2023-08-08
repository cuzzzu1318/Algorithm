package algorithm2023.aug.day08;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1374_강의실 {
	static int N;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		
		//강의를 저장하는 lecture와 강의실을 저장하는 room, 강의는 시작 시각 순, 강의실은 종료 시각순
		PriorityQueue<int[]> lecture = new PriorityQueue<>((o1, o2) -> o1[0] - o2[0]);
		PriorityQueue<Integer> room = new PriorityQueue<>();
		
		int cnt = 1;
		
		//입력과 동시에 강의 저장
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int[] time = new int[2];
			int num = Integer.parseInt(st.nextToken()) - 1;
			time[0] = Integer.parseInt(st.nextToken());
			time[1] = Integer.parseInt(st.nextToken());
			lecture.add(time);
		}
		
		//처음 강의의 종료시간을 강의실에 추가
		room.add(lecture.poll()[1]);
		//강의를 모두 볼 때 까지
		while(!lecture.isEmpty()) {
			//현재 진행중인 강의와 다음 강의를 비교
			int cur = room.peek();
			int[] next = lecture.poll();
			//현재 강의가 끝나야 다음 강의가 시작 -> 한 강의실로 강의 가능
			if(cur<=next[0]) {
				room.poll();
				room.add(next[1]);
			}else {
				//강의 시간이 겹침 -> 강의실 개수 추가
				room.add(next[1]);
				cnt++;
			}
		}
		System.out.println(cnt);

	}
}
