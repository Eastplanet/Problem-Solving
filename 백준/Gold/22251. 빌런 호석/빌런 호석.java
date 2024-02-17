import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int digit[][] = {
			{0,1,2,4,5,6},
			{2,5},
			{0,2,3,4,6},
			{0,2,3,5,6},
			{1,2,3,5},
			{0,1,3,5,6},
			{0,1,3,4,5,6},
			{0,2,5},
			{0,1,2,3,4,5,6},
			{0,1,2,3,5,6}};
	static int map[][];
	static int visited[];
	static int resultCount;
	
	static int N,K,P,X;
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		map = new int[10][10];
		
		for(int i=0;i<10;i++) {
			for(int j=0;j<10;j++) {
				int[] a = digit[i];
				int[] b = digit[j];
				
				//겹치는 lcd 카운트
				int count = 0;
				for(int ai = 0;ai<a.length;ai++) {
					for(int bi=0;bi<b.length;bi++) {
						if(a[ai]==b[bi])count++;
					}
				}
				//i 에서 j로 바꾸는 데에 드는 횟수 저장
				map[i][j] = (a.length - count) + (b.length - count);
			}
		}
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		P = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		
		visited = new int[K];
		
		back(0,0,0);
		
		System.out.println(resultCount);
		
	}
	
	//sum = N이 넘지 않도록, count = lcd 반전 횟수
	public static void back(int idx,int sum,int count) {
		
		//가지치기
		if(sum > N)return;
		
		if(idx == K) {
			if(count <= P && sum <= N && count != 0) {
				if(sum == 0)return;
				resultCount++;
			}
			
			return;
		}
		
		
		for(int i=0;i<10;i++) {
			
			
			int tmp = sum*10 + i;
			
			int now = X;
			for(int j=0;j<K-idx -1;j++) {
				now /= 10;
			}
			now %=10;
			
			visited[idx] = i;
			back(idx+1,tmp, count + map[now][i]);
		}
	}
}