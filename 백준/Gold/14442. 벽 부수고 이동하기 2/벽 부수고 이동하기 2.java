import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	public static StringTokenizer st;
	public static int N,M,K;
	public static int[][] arr;
	public static boolean[][][] visited;
	
	public static void main(String[] args) throws Exception {
		
		int[] dx = {0,0,1,-1};
		int[] dy = {1,-1,0,0};
		
		input();
		
		Queue<Node> q = new ArrayDeque<>();
		q.add(new Node(0,0,0,1));
		
		while(!q.isEmpty()) {
			Node curr = q.poll();
			
			if(curr.x == M-1 && curr.y == N-1) {
				System.out.println(curr.moveCnt);
				return;
			}
			
			for(int i=0;i<4;i++) {
				int gox = curr.x + dx[i];
				int goy = curr.y + dy[i];
				// 배열을 벗어난 경우 스킵
				if(!canGo(gox, goy)) {
					continue;
				}
				// 빈 공간을 만난 경우 방문하지 않았다면 이동
				if(arr[goy][gox] == 0 && visited[goy][gox][curr.breakCnt] == false) {
					visited[goy][gox][curr.breakCnt] = true;
					q.add(new Node(gox,goy,curr.breakCnt,curr.moveCnt+1));
				}
				// 벽을 만난 경우, 벽을 깰 횟수가 남아있고 && 방문한적이 없어야 한다.
				if(arr[goy][gox] == 1 && curr.breakCnt < K && visited[goy][gox][curr.breakCnt+1] == false) {
					visited[goy][gox][curr.breakCnt+1] = true;
					q.add(new Node(gox,goy,curr.breakCnt + 1, curr.moveCnt+1));
				}
			}
		}
		
		System.out.println(-1);
	}
	
	
	public static boolean canGo(int gox, int goy) {
		if(gox < 0 || gox >= M || goy < 0 || goy >= N) {
			return false;
		}
		return true;
	}
	
	public static class Node {
		int x,y,breakCnt,moveCnt;
		public Node(int x,int y,int breakCnt, int moveCnt) {
			this.x = x;
			this.y = y;
			this.breakCnt = breakCnt;
			this.moveCnt = moveCnt;
		}
	}
	
	public static void input() throws Exception {
		st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		arr = new int[N][M];
		visited = new boolean[N][M][K+1];
		
		for(int i=0;i<N;i++) {
			String str = in.readLine();
			for(int j=0;j<M;j++) {
				if(str.charAt(j)=='0') {
					arr[i][j] = 0;
				}
				else {
					arr[i][j] = 1;
				}
			}
		}
	}

	
}