//ACM Craft 
//결과 맞게 나오나 실패로 떠서 

package aug_22;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap; 

public class BJ1050 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//재료의 개수 N, 물약의 식의 개수 M
		String[] NM = br.readLine().split(" ");
		int N = Integer.parseInt(NM[0]);
		int M = Integer.parseInt(NM[1]);

		HashMap<String, Long> mtrlMap = new HashMap<>();
		//비용이 제시된 재료를 맵에 저장
		for(int i = 0; i<N; i++) {
			String[] mtrl = br.readLine().split(" ");
			mtrlMap.put(mtrl[0], Long.parseLong(mtrl[1]));
		}
		
		//레시피로 만들 수 있는 물품 배열
		String[] name = new String[M];
		//레시피 배열
		HashMap<String, Long>[] grd = new HashMap[M];
		for(int i = 0; i<M; i++) {
			grd[i] = new HashMap<String, Long>();
			String recipeS = br.readLine();
			int idx = recipeS.indexOf("=");
			name[i] = recipeS.substring(0,idx);
			recipeS = recipeS.substring(idx+1);
			String[] recipe = recipeS.split("\\+");
			for(int j = 0; j<recipe.length;j++) {
				long cnt = Long.parseLong(recipe[j].substring(0,1));
				String s = recipe[j].substring(1);
				if(grd[i].get(s)!=null) {
					cnt+=grd[i].get(s);
				}
				grd[i].put(s, cnt);
			}
		}
		
		//레시피 하나를 화인 할 때마다 모든 레시피 확인, 제작 가능하면 재료 맵에 저장, 최솟값 발견 시 갱신
		for(HashMap<String, Long> map1 : grd) {
			int n = 0;
			for(HashMap<String, Long> map : grd) {
				Long cnt = (long) 0;
				boolean canMake = true;
				for(String key : map.keySet()) {
					if(mtrlMap.get(key)!=null) {
						cnt+=map.get(key)*mtrlMap.get(key);
					}else {
						canMake = false;
					}
				}
				if(canMake == true) {
					if(mtrlMap.get(name[n])==null) {
						mtrlMap.put(name[n], cnt);
					}
					else if(cnt<mtrlMap.get(name[n])){
						mtrlMap.remove(name[n]);
						mtrlMap.put(name[n], cnt);
					}
				}
				n++;
			}
			
		}
		
		//LOVE제작 가능하면 가격 출력, 1,000,000,000이 넘어가면 1,000,000,001 출력, 제작이 불가능하다면 -1 출력
		if(mtrlMap.get("LOVE")!=null) {
			if(mtrlMap.get("LOVE")>1000000000) {
				System.out.println("1000000001");
			}else {
				System.out.println(mtrlMap.get("LOVE"));
			}
		}else {
			System.out.println("-1");
		}

	}
}
