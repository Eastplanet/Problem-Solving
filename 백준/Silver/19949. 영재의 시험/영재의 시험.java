import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int[] answer = new int[10];
	static int[] visit = new int[10];
	static int result=0;
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		for(int i=0;i<10;i++) {
			answer[i] = Integer.parseInt(st.nextToken());
		}
		
		back(0,-1,-1);
		
		System.out.println(result);
	}
	
	static void back(int count, int pprev,int prev) {
		if(count == 10) {
			int sum = 0;
			for(int i=0;i<10;i++) {
				if(visit[i] == answer[i])sum++;
			}
			if(sum >= 5)result++;
			
			return;
		}
		
		for(int i=1;i<=5;i++) {
			if(i==pprev && pprev == prev)continue;
			
			visit[count] = i;
			back(count +1, prev, i);
		}
	}
}