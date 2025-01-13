import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static StringTokenizer st;

	public static void main(String[] args) throws Exception {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		st = new StringTokenizer(in.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		char[][] arr = new char[N][M];
		int[][] visited = new int[N][M];
		
		PriorityQueue<Node> q = new PriorityQueue<>((Node o1,Node o2)->{
			return o1.hp - o2.hp;
		});
		
		
		for(int i=0;i<N;i++) {
			String tmp = in.readLine();
			for(int j=0;j<M;j++) {
				arr[i][j] = tmp.charAt(j);
				if(arr[i][j] == 'C') {
					q.add(new Node(j,i,0));
				}
			}
		}
		
		
		while(!q.isEmpty()) {
			
			Node curr = q.poll();
			
			if(curr.y == 1 && curr.x == 4) {
				int debug;
				debug = 1 + 0;
				
				
			}
			
			// pq에 넣는 순서가 아닌 pq에서 나오는 순서가 중요하기 떄문에 방문 처리를 뽑고나서 해준다. 
			if(visited[curr.y][curr.x] == 1) {
				continue;
			}
			visited[curr.y][curr.x] = 1; 
			
			char place = arr[curr.y][curr.x];
			
			// 일반 바닥에서는 좌우로 움직일 수 있다.
			if(place == 'C' || place == 'F' || place == 'L') {
				
				int[] dx = {1,-1};
				
				for(int i=0;i<2;i++) {
					int gox = curr.x + dx[i];
					int goy = curr.y;
					
					if(gox < 0 || gox >= M || visited[goy][gox] == 1 || arr[goy][gox] == 'D') {
						continue;
					}
					q.add(new Node(gox,goy,curr.hp + 1));
				}
				
			}
			// 아래에 설치된 사다리가 있는 경우 아래로 움직일 수 있다.
			if(curr.y + 1 < N && arr[curr.y + 1][curr.x] == 'L' && visited[curr.y + 1][curr.x] == 0 && place != 'X') {
				q.add(new Node(curr.x,curr.y + 1,curr.hp + 5));
			}
			// 현재 위치에 설치된 사다리가 있는 경우 움직일 수 있다.??
			if(place == 'L') {
				if(curr.y - 1 >= 0 && visited[curr.y-1][curr.x] == 0 && arr[curr.y-1][curr.x] != 'D') {
					q.add(new Node(curr.x,curr.y-1,curr.hp + 5));
				}
			}
			// 아래가 뚫려있는 공간이면 착지한다.
			if(place == 'X') {
				
				int nowY = curr.y;
				
				while(nowY < N) {
					if(arr[nowY][curr.x] == 'X') {
						nowY++;
						continue;
					}
					break;
				}
				
				// y가 N 이하이고 강아지를 만나지 않는다면
				if( nowY < N && arr[nowY][curr.x] != 'D') {
					q.add(new Node(curr.x,nowY,curr.hp+10));
				}
				
				
			}
			// 문에 위치하면 탈출한다.
			if(place == 'E') {
				System.out.println(curr.hp);
				return;
			}
		}
		System.out.println("dodo sad");
		return;
	}

	
	public static class Node {
		int x,y,hp;
		
		public Node(int x,int y,int hp) {
			this.x = x;
			this.y = y;
			this.hp = hp;
		}
	}
}