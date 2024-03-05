import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	static int N;
	static int[] select;
	static int[] visited;
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(in.readLine());
		select = new int[N];
		visited = new int[N];
		back(0);
	}
	
	static void back(int count) {
		if(count==N) {
			for(int i=0;i<N;i++) {
				System.out.print(select[i]+" ");
			}
			System.out.println();
		}
		
		for(int i=0;i<N;i++) {
			if(visited[i] == 1)continue;
			
			visited[i] = 1;
			select[count] = i+1;
			back(count+1);
			visited[i] = 0;
		}
	}
	
}