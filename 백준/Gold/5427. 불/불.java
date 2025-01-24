import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	public static StringTokenizer st;
	public static int H,W;
	public static char[][] arr;
	public static int[][] fireVisited, manVisited;
	public static Queue<Node> fireQ, manQ;
	public static boolean endFlag;

	public static void main(String[] args) throws Exception {
		
		int T = Integer.parseInt(in.readLine());
		while(T-- > 0) {
			init();
			
			endFlag = false;
			
			int time = 0;
			
			while(!fireQ.isEmpty() || !manQ.isEmpty()) {
				
				fireQ = BFS(fireQ,true);
				manQ = BFS(manQ,false);
				
				if(endFlag) {
					time++;
					break;
				}
				time++;
			}
			
			if(endFlag == true) {
				System.out.println(time);
			}
			else {
				System.out.println("IMPOSSIBLE");
			}
			
			
		}

	}
	
	public static Queue<Node> BFS(Queue<Node> q, boolean isFire){
		Queue<Node> nextMove = new ArrayDeque<>();
		
		int[] dx = {0,0,1,-1};
		int[] dy = {1,-1,0,0};
		
		while(!q.isEmpty()) {
			Node curr = q.poll();
			
			// 탈출 성공
			if(isFire == false && (curr.y == 0 || curr.y == H-1 || curr.x == 0 || curr.x == W-1)) {
				endFlag = true;
				return nextMove;
			}
			
			for(int i=0;i<4;i++) {
				int gox = curr.x + dx[i];
				int goy = curr.y + dy[i];
				
				if(gox < 0 || gox >= W || goy < 0 || goy >= H || arr[goy][gox] == '#' || arr[goy][gox] == '*') {
					continue;
				}
				
				// 불인경우 불이 방문했던곳 방문 금지 
				if(isFire && fireVisited[goy][gox] == 1) {
					continue;
				}
				// 사람인 경우 사람,불이 방문했던 곳 방문 금지
				if(!isFire && (manVisited[goy][gox] == 1 || fireVisited[goy][gox] == 1)) {
					continue;
				}
				
				if(isFire) {
					fireVisited[goy][gox] = 1;
					nextMove.add(new Node(goy,gox));
				}
				if(!isFire) {
					manVisited[goy][gox] = 1;
					nextMove.add(new Node(goy,gox));
				}
			}
			
		}
		
		return nextMove;
	}

	public static void init() throws Exception {
		st = new StringTokenizer(in.readLine());
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		fireVisited = new int[H][W];
		manVisited = new int[H][W];
		arr = new char[H][W];
		fireQ = new ArrayDeque<>();
		manQ = new ArrayDeque<>();
		
		
		for(int i=0;i<H;i++) {
			String tmp = in.readLine();
			for(int j=0;j<W;j++) {
				arr[i][j] = tmp.charAt(j);
				if(arr[i][j] == '@') {
					manQ.add(new Node(i,j));
					arr[i][j] = '.';
				}
				else if(arr[i][j] == '*') {
					fireQ.add(new Node(i,j));
				}
			}
		}
		
	}
	
	public static class Node {
		int x,y;
		public Node (int y,int x) {
			this.x = x;
			this.y = y;
		}
	}

}