import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {

	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static int N, T, M;
    static int[][] arr;
    static int[][] cities;
	
	
    public static void main(String[] args) throws Exception{
    	
    	StringTokenizer st = new StringTokenizer(in.readLine());
    	N = Integer.parseInt(st.nextToken());
    	T = Integer.parseInt(st.nextToken());
    	
    	cities = new int[N+1][3];
    	arr = new int[N+1][N+1];
    	for(int i=0;i<=N;i++) {
    		for(int j=0;j<=N;j++) {
    			arr[i][j] = Integer.MAX_VALUE;
    		}
    	}
    	
    	
    	for(int i=1;i<=N;i++) {
    		st = new StringTokenizer(in.readLine());
    		cities[i][0] = Integer.parseInt(st.nextToken());
    		cities[i][1] = Integer.parseInt(st.nextToken());
    		cities[i][2] = Integer.parseInt(st.nextToken());
    	}

    	for(int i=1;i<=N;i++) {
    		for(int j=1;j<=N;j++) {
    			arr[i][j] = calcDist(cities[i], cities[j]);
    			if(cities[i][0] == 1 && cities[j][0] == 1) {
    				arr[i][j] = Math.min(arr[i][j], T);
    			}
    		}
    	}
    	
    	for(int k=1;k<=N;k++) {
    		for(int i=1;i<=N;i++) {
    			for(int j=1;j<=N;j++) {
    				arr[i][j] = Math.min(arr[i][j], arr[i][k]+arr[k][j]);
    			}
    		}
    	}
    	
    	M = Integer.parseInt(in.readLine());
    	for(int i=0;i<M;i++) {
    		st = new StringTokenizer(in.readLine());
    		int a = Integer.parseInt(st.nextToken());
    		int b = Integer.parseInt(st.nextToken());
    		System.out.println(arr[a][b]);
    	}
    	
    	
    }
    
    public static int calcDist(int[] cityA, int[] cityB) {
    	return Math.abs(cityA[1] - cityB[1]) + Math.abs(cityA[2]-cityB[2]);
	}
}