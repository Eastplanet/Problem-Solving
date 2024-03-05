import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int N,K;
	static int[] arr;
	static int[] visited;
	static int count;
	
	
	public static void main(String[] args) throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(in.readLine());
		arr = new int[N];
		visited = new int[N];
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		back(0, 500);
		System.out.println(count);
	}
	
	static void back(int day, int weight) {
		
		if(weight < 500) {
			return;
		}
		if(day == N) {
			count++;
			return;
		}
		for(int i=0;i<N;i++) {
			if(visited[i] != 1) {
				visited[i] = 1;
				back(day+1,weight-K + arr[i]);
				visited[i] = 0;
			}
		}
	}
}