import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[][] movePos = new int[][]{ {0,1},{1,0},{0,-1},{-1,0} };
	static int arr[][] =new int[50][50];
	static int R, C, T;
	static class P{
		int first,second;

		public P(int first, int second) {
			this.first = first;
			this.second = second;
		}
		
	}
	static boolean canMove(int y, int x) {
	    if (y < 0 || y >= R)return false;
	    if (x < 0 || x >= C)return false;
	    if (arr[y][x] == -1)return false;
	    return true;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		ArrayList<P> airClear= new ArrayList<>();
		StringTokenizer st = new StringTokenizer(in.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		
	    for (int i = 0; i < R; i++) {
	    	st = new StringTokenizer(in.readLine());
	        for (int j = 0; j < C; j++) {
	        	arr[i][j] = Integer.parseInt(st.nextToken());
	            if (arr[i][j] == -1) {
	                airClear.add(new P(i, j));
	            }
	        }
	    }
	    while (T-- > 0) {
	        Queue<P> q = new ArrayDeque<>();
	        int[][] sumarr = new int[50][50];
	        for (int i = 0; i < R; i++) {
	            for (int j = 0; j < C; j++) {
	                if (arr[i][j] != -1 && arr[i][j] != 0)q.add(new P(i, j));
	            }
	        }
	        while (!q.isEmpty()) {
	            P p = q.poll();
	            
	            int count = 0;
	            int dust = arr[p.first][p.second] / 5;
	            int goy, gox;
	            for (int i = 0; i < 4; i++) {
	                goy = p.first + movePos[i][0];
	                gox = p.second + movePos[i][1];
	                if (canMove(goy, gox)) {
	                    count++;
	                    sumarr[goy][gox] += dust;
	                }
	            }
	            dust = dust * count;
	            arr[p.first][p.second] -= dust;
	        }

	        for (int i = 0; i < R; i++) {
	            for (int j = 0; j < C; j++) {
	                arr[i][j] += sumarr[i][j];
	            }
	        }




	        int airX, airY;
	        airY = airClear.get(0).first;
	        airX = airClear.get(0).second;

	        arr[airY - 1][airX] = 0;

	        while (airY != 0) {
	            arr[airY][airX] = arr[airY - 1][airX];
	            airY--;
	        }
	        while (airX != C - 1){
	            arr[airY][airX] = arr[airY][airX + 1];
	            airX++;
	        }
	        while (airY != airClear.get(0).first) {
	            arr[airY][airX] = arr[airY + 1][airX];
	            airY++;
	        }
	        while (airX != airClear.get(0).second) {
	            arr[airY][airX] = arr[airY][airX - 1];
	            airX--;
	        }
	        arr[airClear.get(0).first][airClear.get(0).second] = -1;

	        airY = airClear.get(1).first;
	        airX = airClear.get(1).second;
	        arr[airY + 1][airX] = 0;
	        while (airY != R - 1) {
	            arr[airY][airX] = arr[airY + 1][airX];
	            airY++;
	        }
	        while (airX != C - 1) {
	            arr[airY][airX] = arr[airY][airX + 1];
	            airX++;
	        }
	        while (airY != airClear.get(1).first) {
	            arr[airY][airX] = arr[airY - 1][airX];
	            airY--;
	        }
	        while (airX != airClear.get(1).second) {
	            arr[airY][airX] = arr[airY][airX - 1];
	            airX--;
	        }
	        arr[airClear.get(1).first][airClear.get(1).second] = -1;




	    }
	    int sum = 0;

	    for (int i = 0; i < R; i++) {
	        for (int j = 0; j < C; j++) {
	            if (arr[i][j] != -1)sum += arr[i][j];
	        }
	    }
	    System.out.println(sum);
	}
	
}