import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {

	public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	public static StringTokenizer st;
	public static int N,M;
	public static boolean[][] arr;
	
	public static void main(String[] args) throws Exception {
		
		input();
		
		for(int k=1;k<=N;k++) {
			for(int i=1;i<=N;i++) {
				for(int j=1;j<=N;j++) {
					if(arr[i][k] && arr[k][j]) {
						arr[i][j] = true;
					}
				}
			}
		}
		
		boolean ok = true;
		
		for(int i=1;i<=N;i++) {
			if(arr[i][i]) {
				ok = false;
			}
		}
		
		if(!ok) {
			System.out.println(-1);
			return;
		}
		
		for(int i=1;i<=N;i++) {
			
			int preCnt = 0;
			int postCnt = 0;
			for(int j=1;j<=N;j++) {
				if(arr[j][i])preCnt++;
				if(arr[i][j])postCnt++;
				
			}
			
			System.out.println((preCnt + 1) + " " + (N - postCnt));
		}
		
		
	}
	
	public static void input() throws Exception {
		st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new boolean[N+1][N+1];
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(in.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			arr[A][B] = true;
		}
		
	}

	
}