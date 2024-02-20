import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	
	static ArrayList<Pos>homes = new ArrayList<>();
	static ArrayList<Pos>stores = new ArrayList<>();
	static int[] visit;
	static int[][] dist;
	static int N;
	static int M;
	static int resultMin = Integer.MAX_VALUE;
	
	static class Pos{
		int x;
		int y;
		
		public Pos(int x,int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st =new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		
		
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(in.readLine());
			for(int j=0;j<N;j++) {
				int val = Integer.parseInt(st.nextToken());
				
				if(val == 1) {
					homes.add(new Pos(j,i));
				}
				else if(val == 2) {
					stores.add(new Pos(j,i));
				}
			}
		}
		
		dist = new int[homes.size()][stores.size()];
		
		for(int i=0;i<homes.size();i++) {
			for(int j=0;j<stores.size();j++) {
				Pos hp = homes.get(i);
				Pos sp = stores.get(j);
				
				dist[i][j] = Math.abs(hp.x - sp.x) + Math.abs(hp.y - sp.y);
			}
		}
		
		
		visit = new int[stores.size()];
		
		back(0,0);
		
		System.out.println(resultMin);
		
		
	}
	
	public static void back(int idx, int count) {
		
		if(count > M) {
			return;
		}
		
		if(idx == stores.size() && (count >= 1)) {
			
			int sum = 0;
			
			
			for(int i=0;i<homes.size();i++) {
				
				int min = Integer.MAX_VALUE;
				
				for(int j=0;j<stores.size();j++) {
					if(visit[j] == 0)continue;
					
					min = Math.min(min, dist[i][j]);
					
				}
				
				sum += min;
				
				if(sum == -10) {
					int debug = 5;
					
					debug = 1;
				}
				
			}
			
			if(resultMin > sum)resultMin = sum;
			
			
			return;
		}
		
		
		for(int i = idx;i<stores.size();i++) {
			if(visit[i] == 1) {
				System.out.println("visited");
			}
			
			visit[i] = 1;
			back(i+1, count+1);
			visit[i] = 0;
			back(i+1, count);
		}
	}
}