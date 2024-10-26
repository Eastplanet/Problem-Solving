import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static StringTokenizer st;
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws Exception {
	
		st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[][]arr = new int[N+1][K+1];
		int[][] item = new int[N+1][2];
		
		for(int i=1;i<=N;i++) {
			st = new StringTokenizer(in.readLine());
			int W = Integer.parseInt(st.nextToken());
			int V = Integer.parseInt(st.nextToken());
			item[i][0] = W;
			item[i][1] = V;
		}
		
		
		for(int i=1;i<=N;i++) {
			for(int j=0;j<=K;j++) {
				
				arr[i][j] = arr[i-1][j];
				
				if(j-item[i][0] >= 0) {
					arr[i][j] = Math.max(arr[i][j], arr[i-1][j-item[i][0]]+item[i][1]);
				}
			}
		}
		
		int result = 0;
		for(int i=1;i<=N;i++) {
			result = Math.max(arr[i][K], result);
		}
		
		System.out.println(result);
		
		
		
		
	}
	

}