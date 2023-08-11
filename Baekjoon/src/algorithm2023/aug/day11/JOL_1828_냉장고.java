package algorithm2023.aug.day11;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class JOL_1828_냉장고 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		ArrayList<int[]> materials = new ArrayList<>();
		StringTokenizer st;
		for(int i= 0;i<N;i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int[] m = new int[2];
			m[0] = Integer.parseInt(st.nextToken());
			m[1] = Integer.parseInt(st.nextToken());
			materials.add(m);
		}
		
		Collections.sort(materials, (o1,o2)->o1[1]-o2[1]);
		int max = materials.get(0)[1];
		int cnt =1;
		for(int i = 1;i<materials.size();i++) {
			if(materials.get(i)[0]<=max)continue;
			else {
				cnt++;
				max = materials.get(i)[1];
			}
		}
		System.out.println(cnt);
	}
}
