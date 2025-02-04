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
	public static Pos[] pillar;
	public static int[] alreadyMarkingPillarList;
	public static long[] smellRangeList;
	public static long siruSmellRange;
	public static List<Integer>[] adj; 
	
	// 1: 시루냄새, -1:다른 개, 0: 없음
	public static int[] smellPillarList;

	public static void main(String[] args) throws Exception {

		init();
		
		// siruSmellRange 거리 보다 작은 기둥끼리 전부 연결한다
		for(int i=1;i<=N;i++) {
			for(int j=i+1;j<=N;j++) {
				// 시루의 범위보다 작으면 연결
				long dist = Pos.calcDistance(pillar[i], pillar[j]);
				if(dist <= siruSmellRange) {
					adj[i].add(j);
					adj[j].add(i);
				}
			}
		}
		
		
		
		
		// alreadyMarkingPillarList를 토대로 전부 마킹을 한다.
		for(int i=0;i<M;i++) {
			int nowPillar = alreadyMarkingPillarList[i];
			long smellRange = smellRangeList[i];
			
			smellPillarList[nowPillar] = -1;
			pillar[nowPillar].range = Math.max(pillar[nowPillar].range,smellRange);
		}
		
		for(int i=1;i<=N;i++) {
			
			if(smellPillarList[i] != -1) {
				continue;
			}
			
			for(int j=1;j<=N;j++) {
				if(i == j) {
					continue;
				}
				
				
				if(Pos.calcDistance(pillar[i], pillar[j]) <= Math.max(pillar[i].range,pillar[j].range)) {
					smellPillarList[j] = -1;
				}
			}
		}
		
		
		BFS();
		
		int cnt = 0;
		for(int i=1;i<=N;i++) {
			if(smellPillarList[i] == 1) {
				cnt++;
			}
		}
		System.out.println(cnt);
		
	}
	
	
	public static void BFS() {
		
		int[] visited = new int[N+1];
		
		Queue<Integer> q = new ArrayDeque<>();
		
		for(int i=1;i<=N;i++) {
			if(smellPillarList[i] == 0) {
				q.add(i);
				visited[i] = 1;
				smellPillarList[i] = 1;
			}
		}
		
		
		while(!q.isEmpty()) {
			int curr = q.poll();
			
			for(int next : adj[curr]) {
				// 방문했거나 냄새가 닿을 수 없다면
				if(visited[next] == 1) {
					continue;
				}
				
				smellPillarList[next] = 1;
				visited[next] = 1;
				q.add(next);
			}
		}
	}
	
	

	public static void init() throws Exception {
		st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		smellPillarList = new int[N+1];
		alreadyMarkingPillarList = new int[N+1];
		pillar = new Pos[N+1];
		adj = new ArrayList[N+1];
		for(int i=1;i<=N;i++) {
			adj[i] = new ArrayList<Integer>();
		}
		
		M = Integer.parseInt(st.nextToken());
		for(int i=1;i<=N;i++) {
			st = new StringTokenizer(in.readLine());
			pillar[i] = new Pos(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
		}
		
		smellRangeList = new long[M];
		
		st = new StringTokenizer(in.readLine());
		for(int i=0;i<M;i++) {
			alreadyMarkingPillarList[i] = Integer.parseInt(st.nextToken());
		}
		
		
		st = new StringTokenizer(in.readLine());
		siruSmellRange = Integer.parseInt(st.nextToken());
		siruSmellRange *= siruSmellRange;
		for(int i=0;i<M;i++) {
			smellRangeList[i] = Integer.parseInt(st.nextToken());
			smellRangeList[i] *= smellRangeList[i];
		}
	}
	
	

	public static class Pos {
		int x,y;
		long range;
		public Pos(int x,int y) {
			this.x = x;
			this.y = y;
		}
		// Pos 간 거리를 리턴
		public static long calcDistance(Pos a, Pos b) {
			return (a.x - b.x)*(a.x - b.x) +(a.y - b.y)*(a.y - b.y);
		}
	}
}