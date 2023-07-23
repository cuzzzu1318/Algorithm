//ACM Craft 

package algorithm2022.aug;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.io.IOException; 


class acmGraph{
	int number = 0;
	int delay = 0;
	ArrayList<acmGraph> next = new ArrayList<acmGraph>(); 
	ArrayList<acmGraph> prev = new ArrayList<acmGraph>(); 
	acmGraph(){
		
	}
	
	acmGraph(String delay, int number){
		this.delay = Integer.parseInt(delay);
		this.number = number;
	}
	
	void addNext(acmGraph AG) {
		this.next.add(AG);
	}
	void addprev(acmGraph AG) {
		this.prev.add(AG);
	}
}

public class BJ1005 {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		//�׽�Ʈ���̽��� ���� T, �ǹ��� ���� N, �Ǽ����� ��Ģ�� �� ���� K
		int T = Integer.parseInt(bf.readLine());
		int[] cnt = new int[T];
		for(int i = 0;i<T;i++) {
			
			String[] NK = bf.readLine().split(" ");
			int N = Integer.parseInt(NK[0]);
			int K = Integer.parseInt(NK[1]);
			acmGraph[] AGs = new acmGraph[N];
			
			//�ǹ� �� �Ǽ��ð� ����
			String delays = bf.readLine();
			String[] arr = delays.split(" ");
			for(int j = 0;j<N;j++) {
				AGs[j] = new acmGraph(arr[j], j);
			}
			
			//�� �ǹ� ����
			for(int j = 0; j < K; j++) {
				String[] XY = bf.readLine().split(" ");
				int X = Integer.parseInt(XY[0]);
				int Y = Integer.parseInt(XY[1]);
				AGs[X-1].addNext(AGs[Y-1]);
				AGs[Y-1].addprev(AGs[X-1]);
				
			}
			
			//�������� ����� �ϴ� �ǹ� W
			int W = Integer.parseInt(bf.readLine());
			acmGraph cur = AGs[W-1];
			cnt[i] = 0;
			int[] delaySum = new int[N];
			for(acmGraph a : AGs) {
				delaySum[a.number] = a.delay;
			}
			
			Queue<Integer> DP = new LinkedList<Integer>();
			
			//W�� prev�� �� �� ���� Ž���Ͽ� �Ǽ��ð� ���
			while(!cur.prev.isEmpty()) {
				for(acmGraph a : AGs) {
					if(a.prev.isEmpty()) {
						DP.add(a.number);
//						System.out.println("\t"+a.number);
						for(acmGraph b : a.next) {
							if(delaySum[b.number]<=b.delay+delaySum[a.number]) {
//								System.out.println("a.delay: "+a.delay);
								delaySum[b.number] = b.delay + delaySum[a.number];		
//								System.out.println("b: "+(b.number)+" delay: "+delaySum[b.number]);
							}
							b.prev.remove(a);
						}
					}
					
				}
			}
			cnt[i] = delaySum[W-1];
		}
		for(int i : cnt) {
			System.out.println(i);
		}
	}
}
