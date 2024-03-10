import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	
	static int N,H,D, minDist = Integer.MAX_VALUE;
	static int[] start = new int[2];
	static int[] end = new int[2];
	static ArrayList<int[]>u = new ArrayList<>();
	
	//현재 위치, 현재까지 온 거리, 이때 까지 방문한 우산들, 현재 체력, 현재 우산 내구도
	static class Status{
		int[] pos;
		int dist;
		int[] visited;
		int hp;
		int umbHP;
		public Status(int[] pos, int dist, int[] visited, int hp, int umbHP) {
			super();
			this.pos = pos;
			this.dist = dist;
			this.visited = visited;
			this.hp = hp;
			this.umbHP = umbHP;
		}
	}
	
	public static void main(String[] args) throws Exception {
		init();
		
		// 사람이 가는 곳은 1. 안전지대 이거나 우산 위치 2개 뿐이다.
		
		Queue<Status>q = new ArrayDeque<Status>();
		q.add(new Status(start,0,new int[u.size()],H,0));
		
		while(!q.isEmpty()) {
			Status curr = q.poll();
			
			//가지치기를 해도 시간이 똑같음... 머지?
//			if(curr.dist > minDist) {
//				continue;
//			}
			
			// 1. 안전 지대로 갈 수 있는지 확인
			if(canGo(curr.pos, end, curr.hp+curr.umbHP)) {
				
				int d = curr.dist+getDist(curr.pos, end);
				if(minDist > d) {
					minDist = d;
				}
				continue;
			}
			
			// 2. 우산 위치로 갈 수 있는지 확인
			for(int i=0;i<u.size();i++) {
				if(curr.visited[i]==1)continue;
				
				if(canGo(curr.pos,u.get(i),curr.hp+curr.umbHP)) {
					
					//방문처리 한 배열을 넘겨 준다.
					int[] tmpvisited = new int[u.size()];
					for(int j=0;j<u.size();j++) {
						tmpvisited[j] = curr.visited[j];
					}
					tmpvisited[i] = 1;
					

					int d = getDist(curr.pos, u.get(i));
					if(curr.umbHP >= d) {
						q.add(new Status(u.get(i), curr.dist+d, tmpvisited, curr.hp, D-1));
					}
					else {
						q.add(new Status(u.get(i), curr.dist+d, tmpvisited, curr.hp+1-(d-curr.umbHP), D-1));
					}
					
				}
			}
		}
		
		if(minDist == Integer.MAX_VALUE) {
			System.out.println(-1);
		}
		else {
			System.out.println(minDist);
		}
		
	}
	
	
	// 거리가 현재 체력보다 크다면 갈 수 없음
	static boolean canGo(int[] start, int[] end, int leftHp) {
		int dist = getDist(start, end);
		if(dist > leftHp)return false;
		return true;
	}
	
	static int getDist(int[] a, int[]b) {
		return Math.abs(a[0]-b[0])+Math.abs(a[1]-b[1]);
	}
	
	static void init()throws Exception{
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		for(int i=0;i<N;i++) {
			String s = in.readLine();
			for(int j=0;j<N;j++) {
				char tmp = s.charAt(j);
				if(tmp == 'S') {
					start[0] = i;
					start[1] = j;
				}
				else if(tmp == 'E') {
					end[0] = i;
					end[1] = j;
				}
				else if(tmp == 'U') {
					u.add(new int[] {i,j});
				}
			}
		}
	}
}