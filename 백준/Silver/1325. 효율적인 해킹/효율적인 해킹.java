import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	public static StringTokenizer st;

	public static int N,M;
	public static List<Integer>[] adj;
	public static int max;
	public static List<Integer> candidate = new ArrayList<>();
	
	public static void main(String[] args) throws Exception {

		init();
		
		for(int i=1;i<=N;i++) {
			BFS(i);
		}
		
		Collections.sort(candidate);
		for(int i=0;i<candidate.size();i++) {
			System.out.print(candidate.get(i)+" ");
		}
	}
	
	public static void BFS(int num) {
		
		Queue<Integer> q = new ArrayDeque<>();
		q.add(num);
		
		int[] localVisited = new int[N+1];
		
		int sum = 1;
		localVisited[num] = 1;
		
		while(!q.isEmpty()) {
			int curr = q.poll();
			
			for(int next : adj[curr]) {
				if(localVisited[next] == 1) {
					continue;
				}
				localVisited[next] = 1;
				q.add(next);
				sum++;
			}
		}
		
		if(max < sum) {
			candidate.clear();
			candidate.add(num);
			max = sum;
		}
		else if(max == sum) {
			candidate.add(num);
		}
	}
	
	public static void init() throws Exception {
		st = new StringTokenizer(in.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		adj = new ArrayList[N+1];
		for(int i=1; i<= N; i++) {
			adj[i] = new ArrayList<>();
		}
		
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(in.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			adj[b].add(a);
		}
	}
	
	

}