package algorithm2024.mar.day08;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ_4195_친구네트워크 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static HashMap<String, String> parent;
	static HashMap<String, Integer> network;

	/*Union-Find
	* 문자열을 인덱스로 사용하는 Union-find
	* 기존의 Union-find에서 사용하는 parent 배열과 인접 리스트 혹은 행렬을 모두 HashMap으로 대체
	*/
	static int union(String f1, String f2) {
		String pf1 = find(f1);
		String pf2 = find(f2);
		if(!pf1.equals(pf2)){
			parent.put(pf2,pf1);
			network.put(pf1, network.get(pf2)+network.get(pf1));
		}
		return network.get(pf1);
	}

	static String find(String f) {
		if(parent.get(f).equals(f))return f;
		String p = find(parent.get(f));
		parent.put(f,p);
		return p;
	}
	public static void main(String[] args) throws Exception {
		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			int F = Integer.parseInt(br.readLine());


			//네트워크의 root를 지정하는 parent 맵과 network의 총 친구 수를 저장하는 network 맵
			parent = new HashMap<>();
			network = new HashMap<>();

			/*
			* 매 번 입력 받을 때 마다 이미 존재하면 기존의 값 put, 없으면 초기 값 put.
			* 초기 값: parent-본인 이름, network-1
			* put 이후에 두 이름으로 union 진행*/
			for (int j = 0; j < F; j++) {
				st = new StringTokenizer(br.readLine());
				String f1 = st.nextToken();
				String f2 = st.nextToken();
				parent.put(f1,parent.getOrDefault(f1,f1));
				network.put(f1,network.getOrDefault(f1,1));
				parent.put(f2,parent.getOrDefault(f2,f2));
				network.put(f2,network.getOrDefault(f2,1));
				sb.append(union(f1,f2)).append("\n");
			}
		}
		System.out.println(sb);
	}

}
