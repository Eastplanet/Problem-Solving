package ps;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_1111 {
	
	static int N;
	static int[] arr = new int[51];
	static int[] inc = new int[51];
	
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	
	
	
	
	public static void main(String[] args) throws Exception{
		
		input();
		
		for(int i=0;i<N-1;i++) {
			inc[i] = arr[i+1]-arr[i];
		}
		
		if(N==1) {
			System.out.println("A");
			return;
		}
		else if(N==2) {
			if(arr[0] == arr[1]) {
				System.out.println(arr[0]);
				return;
			}
			else {
				System.out.println("A");
				return;
			}
		}
		else {
			// (y - y1) = m(x-x1)
			// y = mx -m*x1 + y1
			// y = mx + n
			double m = ((double)inc[1]-inc[0])/((double)arr[1]-arr[0]);
			int n = (int)(-m*arr[0] + inc[0]);
			
			boolean isCorrect = true;
			for(int i=0;i<N;i++) {
				if(i==0)continue;
				
				int y = (int)m*arr[i-1] + n;
				if(y + arr[i-1] != arr[i]) {
					isCorrect = false;
					break;
				}
			}
			
			if(isCorrect) {
				int y = (int)m*arr[N-1] + n;
				System.out.println(y+arr[N-1]);
				return;
			}
			else {
				System.out.println("B");
			}
		}
		
		
		
		
	}
	
	
	public static void input()  throws Exception {
		
		
		
		String []tmp;
		N = Integer.parseInt(in.readLine());
		arr = new int[51];
		tmp = in.readLine().split(" ");
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(tmp[i]);
		}
	}
}
