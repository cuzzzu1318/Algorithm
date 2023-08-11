package algorithm2023.aug.day11;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class BOJ_1302_베스트셀러 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Map<String, Integer> map = new HashMap<>();
		int max = 0;
		String maxN = "";
		for(int i= 0;i<N;i++) {
			String name = br.readLine();
			if(map.containsKey(name)) {
				map.replace(name, map.get(name)+1);
			}else {
				map.put(name, 1);
			}
			int cnt = map.get(name);
			if(cnt>=max) {
				if(cnt==max) {
					if(name.compareTo(maxN)<0) {
						maxN = name;
					}
				}else {
					max = cnt;
					maxN = name;
				}
			}
		}
		
		System.out.println(maxN);
		
		
	}
	
}
