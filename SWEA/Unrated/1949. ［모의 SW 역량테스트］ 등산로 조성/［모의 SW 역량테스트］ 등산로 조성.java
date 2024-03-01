import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static ArrayList<Integer[]> startPoint;

	static int N, K, maxRout;
	static int[][] arr, visited;
	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { 1, -1, 0, 0 };

	public static void main(String[] args) throws Exception {

		int T = Integer.parseInt(in.readLine());
		for (int tc = 1; tc <= T; tc++) {
			init();
			trim();
			sb.append("#").append(tc).append(" ").append(maxRout).append("\n");
		}
		System.out.println(sb);
	}

	public static void trim() {
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				for(int k=1;k<=K;k++) {
					arr[i][j] -= k;
					findRout();
					arr[i][j] += k;
				}
			}
		}
	}
	
	public static void findRout() {
		visited = new int[N][N];
		for (Integer[] curr : startPoint) {
			visited[curr[0]][curr[1]] = 1;
			dfs(curr);
		}
	}
	
	public static void dfs(Integer[] curr) {
		
		int x = curr[1];
		int y = curr[0];
		int dist = curr[2];
		if(maxRout < dist) {
			maxRout = dist;
		}
		
		for(int i=0;i<4;i++) {
			int gox = x + dx[i];
			int goy = y + dy[i];
			if(!isIn(gox,goy))continue;
			// 이전 방문이 더 유망하면 continue;
			if(visited[goy][gox] >= dist + 1)continue;
			if(arr[y][x] > arr[goy][gox]) {
				visited[goy][gox] = dist+1;
				dfs(new Integer[] {goy,gox,dist+1});
			}
		}
	}
	
	public static boolean isIn(int x, int y) {
		if(x < 0 || x>=N)return false;
		if(y < 0 || y>=N)return false;
		return true;
	}

	public static void init() throws Exception {
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		arr = new int[N][N];
		maxRout = 1;
		
		int max = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(max < arr[i][j]){
					max = arr[i][j];
				}
			}
		}
		// 시작 지점 만들기
		startPoint = new ArrayList<>();
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(max == arr[i][j]) {
					startPoint.add(new Integer[]{i,j,1});
				}
			}
		}
	}
}