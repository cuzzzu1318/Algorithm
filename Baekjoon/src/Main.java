import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//유기농배추
public class Main {

	static int[] dx = {-1 , 1 , 0 , 0};
	static int[] dy = { 0,  0 , -1 ,1};
	static int[][] visited, arr;
	static int count,x,y;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		for(int t = 0 ; t < N ; t++) {
			count = 0;
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			
			 y = Integer.parseInt(st.nextToken()); //열
			 x = Integer.parseInt(st.nextToken()); //행
			int k = Integer.parseInt(st.nextToken()); //배추
			
			arr = new int[x][y];
			visited = new int[x][y];
			for(int i = 0 ; i < k ; i++) {
				st = new StringTokenizer(br.readLine()," ");
				int c = Integer.parseInt(st.nextToken());
				int r = Integer.parseInt(st.nextToken());
				arr[r][c] = 1;
			}
			
			for(int i = 0 ; i< x ; i++) {
				for(int j = 0 ; j < y ; j++) {
					if(arr[i][j]== 1 && visited[i][j] == 0 ) {
						count++;
						dfs(i,j);
					}
					
				}
			}
			
			System.out.println(count);
		}//tc
	}//main
	private static void dfs(int cr, int cs) {
		visited[cr][cs] = 1; //방문 췍
		int nx ;
		int ny ;
		for(int i = 0 ; i < 4; i++) {
			nx = cr + dx[i];
			ny = cs + dy[i];
			if(nx >=0 &&ny >= 0 && nx <x && ny < y && arr[nx][ny]==1) { //경계값 + 연결검사
				if(visited[nx][ny]==1)continue;
				dfs(nx,ny);
			}
		}
		
	}//dfs
}//class