import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int W,H;
	static int[] hdx = {1,1,-1,-1,2,2,-2,-2};
	static int[] hdy = {2,-2,2,-2,1,-1,1,-1};
	static int[] dx = {0,0,1,-1};
	static int[] dy = {1,-1,0,0};
	static int[][] arr;
	static int[][][] visited;
	
	public static boolean canGo(int x,int y) {
		if(x < 0 || x >= W)return false;
		if(y < 0 || y >= H)return false;
		if(arr[y][x] == 1)return false;
		return true;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int HorseMove = Integer.parseInt(in.readLine());
		StringTokenizer st = new StringTokenizer(in.readLine());
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		arr = new int[H][W];
		visited = new int[H][W][HorseMove+1];
		
		for(int i=0;i<H;i++) {
			st = new StringTokenizer(in.readLine());
			for(int j=0;j<W;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		Queue<Integer[]> q = new ArrayDeque<>();
		
		q.add(new Integer[] {0,0,0,0});
		visited[0][0][0] = 1;
		
		while(!q.isEmpty()) {
			Integer[] curr = q.poll();
			if(curr[0] == H-1 && curr[1] == W-1) {
				System.out.println(curr[3]);
				return;
			}
			
			if(curr[2] != HorseMove) {
				for(int i=0;i<8;i++) {
					int gox = curr[1] + hdx[i];
					int goy = curr[0] + hdy[i];
					if(!canGo(gox,goy))continue;
					if(visited[goy][gox][curr[2] + 1] == 1)continue;
					visited[goy][gox][curr[2] + 1] = 1;
					q.add(new Integer[] {goy,gox,curr[2]+1,curr[3]+1});
				}
			}
			
			for(int i=0;i<4;i++) {
				int gox = curr[1] + dx[i];
				int goy = curr[0] + dy[i];
				if(!canGo(gox, goy))continue;
				if(visited[goy][gox][curr[2]]==1)continue;
				visited[goy][gox][curr[2]] = 1;
				q.add(new Integer[] {goy,gox,curr[2],curr[3]+1});
			}
			
		}
		
		System.out.println("-1");
	}
}