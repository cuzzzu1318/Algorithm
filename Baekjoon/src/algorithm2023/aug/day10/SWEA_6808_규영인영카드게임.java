package algorithm2023.aug.day10;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_6808_규영인영카드게임 {
	static int win, lose, gy[], iy[], tgt[];
	static int cnt = 0;
	static boolean[] card;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t = 1;t<=T;t++) {
			win = 0;
			lose = 0;
			gy = new int[9];
			iy = new int[9];
			tgt = new int[9];
			card = new boolean[19];
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int i= 0;i<9;i++) {
				int n = Integer.parseInt(st.nextToken());
				gy[i] = n;
				card[n] = true;
			}
			int idx = 0;
			for(int i =1;i<19;i++) {
				if(!card[i])iy[idx++] = i;
			}
			while(true) {
				if(gyWin())win++;
				else lose++;
				if(!np())break;
			}
			sb.append("#").append(t).append(" ").append(win).append(" ").append(lose).append("\n");
		}
		System.out.println(sb);
	}
	
	static boolean np() {
		//3가지
		//앞에서 교환되어야 하는 인덱스 & 작업
		int i = iy.length-1;
		while(i>0&&iy[i-1]>=iy[i])--i;
		
		//이미 가장 큰 수
		if(i==0)return false;
		//뒤에서 교환되어야 하는 인덱스 & 작업
		int j= iy.length-1;
		while(iy[i-1]>=iy[j])--j;
		//교환 후 뒤쪽을 작은수로 정리
		swap(i-1,j);
		int k= iy.length-1;
		while(i<k) swap(i++,k--);
		//np()호출 전보다 바로 다음 큰 수를 만듬
		return true;
	}
	static void swap(int i, int j) {
		int temp = iy[i];
		iy[i] = iy[j];
		iy[j] = temp;
	}
	
	static boolean gyWin() {
		int gyScore = 0;
		int iyScore = 0;
		
		for(int i = 0;i<9;i++) {
			int sum = gy[i]+iy[i];
			if(gy[i]>iy[i]) {
				gyScore+=sum;
			}else {
				iyScore+=sum;
			}
		}
		return (gyScore>iyScore)?true:false;
	}
}
