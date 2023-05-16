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
			//����, �ߺ��� ���, ����� ��� ������ �ڷᱸ���� treemap���
			for (int i = 0; i < k; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				String func = st.nextToken();
				int n = Integer.parseInt(st.nextToken());
				switch (func) {
				case "I":
					//������ ��� �̹� �����Ѵٸ� ���� +1���ְ� ���ٸ� 1�� ����
					map.put(n, map.getOrDefault(n, 0)+1);
					break;
				default:
					//������ ��� 
					if(map.isEmpty()) {
					//���� ����ִٸ� continue
						continue;
					}
					int remove;
					//-1�� 1�� �� ���� �ٸ� ���⿡�� �� ����
					if(n==-1) {
						remove = map.firstKey();
					}else {
						remove = map.lastKey();
					}
					//������ ���� �̿��Ͽ� ���� �� ����
					map.put(remove, map.get(remove)-1);
					if(map.get(remove)==0) {
					//���� ���� 0�̶�� �������� �ʾƾ� �ϹǷ� ����
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