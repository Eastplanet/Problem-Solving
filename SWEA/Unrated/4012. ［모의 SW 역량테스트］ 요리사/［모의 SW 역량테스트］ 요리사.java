import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
	static int N;
	static int[][] arr;
	static int[] visited;
	static int min;
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		
		int T = Integer.parseInt(in.readLine());
		for(int tc = 1 ; tc <= T ; tc++) {
			N = Integer.parseInt(in.readLine());
			arr = new int[N][N];
			visited = new int[N];
			min = Integer.MAX_VALUE;
			
			for(int i=0;i<N;i++) {
				StringTokenizer st = new StringTokenizer(in.readLine());
				for(int j=0;j<N;j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			back(0,0);
			System.out.println("#"+tc+" "+min);
			
			
		}
	}
	
	
	public static void back(int idx, int count) {
		
		
		if(count == N/2) {
			int sum1 = 0;
			int sum2 = 0;
			
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					if(i==j)continue;
					if(visited[i] == 1 && visited[j] == 1) {
						sum1 += arr[i][j];
					}
					else if(visited[i] == 0 && visited[j] == 0) {
						sum2 += arr[i][j];
					}
				}
			}
			
			if(min > Math.abs(sum1-sum2)) {
				
				min = Math.abs(sum1-sum2);
				}
			
			
			return;
		}
		
		for(int i=idx;i<N;i++) {
			if(visited[i] == 1)continue;
			
			visited[i] = 1;
			back(i, count+1);
			visited[i] = 0;
		}
	}
}