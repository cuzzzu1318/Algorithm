package may_2023;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class G4_BOJ7662_0516 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws NumberFormatException, IOException {
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			int k = Integer.parseInt(br.readLine());
			TreeMap<Integer, Integer> map = new TreeMap<>();
			//정렬, 중복값 허용, 양방향 출력 가능한 자료구조인 treemap사용
			for (int i = 0; i < k; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				String func = st.nextToken();
				int n = Integer.parseInt(st.nextToken());
				switch (func) {
				case "I":
					//삽입의 경우 이미 존재한다면 값을 +1해주고 없다면 1을 삽입
					map.put(n, map.getOrDefault(n, 0)+1);
					break;
				default:
					//삭제의 경우 
					if(map.isEmpty()) {
					//맵이 비어있다면 continue
						continue;
					}
					int remove;
					//-1과 1일 때 각각 다른 방향에서 값 추출
					if(n==-1) {
						remove = map.firstKey();
					}else {
						remove = map.lastKey();
					}
					//추출한 값을 이용하여 맵의 값 감소
					map.put(remove, map.get(remove)-1);
					if(map.get(remove)==0) {
					//맵의 값이 0이라면 존재하지 않아야 하므로 제거
						map.remove(remove);
					}
				}
			}
			if (map.isEmpty()) {
				sb.append("EMPTY\n");
			} else {
				sb.append(map.lastKey()+" "+map.firstKey()+"\n");
			}
		}
		System.out.println(sb);
		
	}
}