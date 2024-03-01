import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	
	static int Y, X, K;
	static int[][] arr;
	static int[] visited;
	static boolean findFlag;

	public static void main(String[] args) throws Exception {
		

		int T = Integer.parseInt(in.readLine());
		for (int tc = 1; tc <= T; tc++) {
			
			
			init();

			for (int i = 0; i <= Y; i++) {
				makeComb(0, 0, i);
				if(findFlag) {
					sb.append("#").append(tc).append(" ").append(i).append("\n");
					break;
				}
			}
		}
		
		System.out.println(sb);
		
	}

	public static void makeComb(int start, int count, int R) {
		if (count == R) {
			if(testing()) {
				findFlag = true;
			}
		}
		
		for (int i = start; i < Y; i++) {
			if (visited[i] != -1)continue;

			visited[i] = 1; // A 선택
			makeComb(i, count + 1, R);
			
			visited[i] = 0; // B 선택
			makeComb(i, count + 1, R);
			
			visited[i] = -1;
		}
		
		return;
	}

	public static boolean testing() {

		for (int x = 0; x < X; x++) {
			
			int nowType = -1;
			int nowLeng = 0;
			int maxLeng = 1;
			
			for (int y = 0; y < Y; y++) {
				int val = arr[y][x];
				if(visited[y] != -1) {
					val = visited[y];
				}
				
				if(nowType != val) {
					nowType = val;
					nowLeng = 1;
				}
				else {
					nowLeng++;
					if(maxLeng < nowLeng) {
						maxLeng = nowLeng;
					}
				}
			}
			
			if(maxLeng < K)return false;
		}
		
		return true;
	}

	public static void init() throws Exception {
		StringTokenizer st = new StringTokenizer(in.readLine());
		Y = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		findFlag = false;
		visited = new int[Y];
		Arrays.fill(visited, -1);
		arr = new int[Y][X];
		for (int i = 0; i < Y; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < X; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	}
}