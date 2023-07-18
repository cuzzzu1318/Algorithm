package oct_2022;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.swing.plaf.basic.BasicComboBoxUI.ItemHandler;

public class BJ2108 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		ArrayList<Integer> arr = new ArrayList<>();
		HashMap<Integer, Integer> modeMap = new HashMap<>();
		for(int i = 0;i<N;i++) {
			arr.add(Integer.parseInt(br.readLine()));
		}
		double sum = 0;
		int avg;//������
		int med;//�߾Ӱ�
		int mode;//�ֺ�
		int range;//����
		arr.sort(null);
		for(int n : arr) {
			sum+=n;
		}
		avg = (int)(Math.round(sum/N));
		med = arr.get(N/2);
		for(int i: arr) {
			if(modeMap.containsKey(i)) {
				modeMap.replace(i, modeMap.get(i)+1);
			}else {
				modeMap.put(i, 1);
			}
		}
		List<HashMap.Entry<Integer,Integer>> entryList = new LinkedList<>(modeMap.entrySet());
		entryList.sort(Map.Entry.comparingByValue());
		
		int lastIndex = entryList.size()-1;
		int num = entryList.get(lastIndex).getValue();
		entryList.removeIf(item->item.getValue()!=num);
		entryList.sort(Map.Entry.comparingByKey());
		
		if(entryList.size()>1) {
			mode = entryList.get(1).getKey();
		}else {
			mode = entryList.get(0).getKey();
		}
		
		range = arr.get(N-1)-arr.get(0);
		System.out.print(avg+"\n"+med+"\n"+mode+"\n"+range+"\n");	
		}
}
