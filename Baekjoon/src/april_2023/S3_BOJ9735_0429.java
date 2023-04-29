package april_2023;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.security.KeyStore.Entry;
import java.util.ArrayList;
import java.util.HashMap;

public class S3_BOJ9735_0429 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws NumberFormatException, IOException {
		int T = Integer.parseInt(br.readLine());
		//테스트 케이스의 수
		for(int t = 0;t<T;t++) {
			int n = Integer.parseInt(br.readLine());
			//옷의 가지 수
			HashMap<String, ArrayList<String>> map = new HashMap<>();
			//옷을 종류별로 저장하기 위해 HashMap사용
			for(int i = 0;i<n;i++) {
				String[] s = br.readLine().split(" ");
				if(map.containsKey(s[1])) {
					//해당 종류가 맵에 있다면 옷만 추가
					map.get(s[1]).add(s[0]);
				}else {
					//맵에 없는 종류의 옷이라면 종류와 함께 추가
					ArrayList<String> temp = new ArrayList<>();
					temp.add(s[0]);
					map.put(s[1], temp);
				}
			}
			int sum = 1;
			for(ArrayList<String> val : map.values()) {
				//계산
				sum*= val.size()+1;
			}
			sum--;
			if(n==0) {
				//옷이 하나도 없다면 입고 나갈 수 없기 때문에 0으로 다시 초기화
				sum=0;
			}
			bw.write(Integer.toString(sum)+"\n");
		}

		bw.flush();
		bw.close();
	}
}