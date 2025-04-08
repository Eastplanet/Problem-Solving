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
	public static int N, maxSize;
	public static char[][] arr;

	public static void main(String[] args) throws Exception {

		init();

		List<int[]> bigIceRootPos = findBigIce();
		
		int maxLength = Integer.MAX_VALUE;
		for(int[] pair : bigIceRootPos) {
			maxLength = Math.min(maxLength, pair[1]);
		}
		
		System.out.println(maxSize + " " + maxLength);
		
	}
	

	public static List<int[]> findBigIce() {
		
		List<int[]> result = new ArrayList<>();
		int[][] visited = new int[N][N];

		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				
				// 방문 X, 아이스크림인 경우
				if(arr[i][j] == '#' && visited[i][j] == 0) {
					int[] sizeAndLength = BFS(j,i,visited);
					
					if(sizeAndLength[0] > maxSize) {
						result.clear();
						result.add(sizeAndLength);
						maxSize = sizeAndLength[0];
					}
					else if(sizeAndLength[0] == maxSize) {
						result.add(sizeAndLength);
					}
				}
			}
		}

		return result;
	}
	
	public static int[] BFS(int x,int y,int[][] visited) {
		
		int[] dx = new int[] {0,0,1,-1};
		int[] dy = new int[] {1,-1,0,0};
		
		Queue<int[]> q = new ArrayDeque<>();
		
		int size = 0;
		int length = 0;
		visited[y][x] = 1;
		q.add(new int[] {y,x});
		
		while(!q.isEmpty()) {
			int[] curr = q.poll();
			size++;
			
			for(int i=0;i<4;i++) {
				int gox = curr[1] + dx[i];
				int goy = curr[0] + dy[i];
				
				if(gox < 0 || gox >= N || goy < 0 || goy >= N || arr[goy][gox] == '.') {
					length++;
					continue;
				}
				
				if(visited[goy][gox] == 1) {
					continue;
				}
				
				visited[goy][gox] = 1;
				q.add(new int[] {goy,gox});
			}
		}
		
		return new int[] {size,length};
	}

	public static void init() throws Exception {
		N = Integer.parseInt(in.readLine());
		arr = new char[N][N];
		
		for (int i = 0; i < N; i++) {
			String tmp = in.readLine();
			for (int j = 0; j < N; j++) {
				arr[i][j] = tmp.charAt(j);
			}
		}
	}

}