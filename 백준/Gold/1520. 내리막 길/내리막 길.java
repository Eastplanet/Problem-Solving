import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static int[][] arr;
	static int[][] dp;
	static int[] dx = {0,0,1,-1};
	static int[] dy = {1,-1,0,0};
	static int N,M;
	static int cnt;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		dp = new int[N][M];
		
		for(int i=0;i<N;i++)Arrays.fill(dp[i], -1);
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(in.readLine()); 
			for(int j=0;j<M;j++) {
				arr[i][j] =Integer.parseInt(st.nextToken());
			}
		}
		
		DFS(0,0);
		if(dp[0][0] == -1)System.out.println(0);
		else System.out.println(dp[0][0]);
		
	}
	
	static int DFS(int y,int x) {
		if(dp[y][x] != -1) return dp[y][x];
		if(y==N-1 && x == M-1) return 1;
		
		int sum = 0;
		
		for(int i=0;i<4;i++) {
			int gox = x + dx[i];
			int goy = y + dy[i];
			if(isIn(goy, gox) && arr[goy][gox] < arr[y][x]) {
				 sum += DFS(goy,gox);
			}
		}
		
		return dp[y][x] = sum;
	}
	
	static boolean isIn(int y,int x) {
		if(x<0 || x>= M)return false;
		if(y<0 || y>= N)return false;
		return true;
	}
}