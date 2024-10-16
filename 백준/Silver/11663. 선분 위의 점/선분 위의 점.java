import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static StringTokenizer st;
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws Exception {
		
		st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int []points = new int[N];
		
		st = new StringTokenizer(in.readLine());
		for(int i=0;i<N;i++) {	
			points[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(points);
		
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(in.readLine());
			
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			
			int findFirstIdx = -1;
			
			int start = 0;
			int end = N-1;
			
			while(start <= end) {
				int mid = (start+end)/2;
				
				if(A <= points[mid] && points[mid] <= B) {
					findFirstIdx = mid;
					end = mid-1;
				}
				else if(A > points[mid]) {
					start = mid +1;
				}
				else {
					end = mid-1;
				}
			}
			
			
			int findLastIdx = -1;
			start = 0;
			end = N-1;
			
			while(start <= end) {
				int mid = (start+end)/2;
				
				if(A <= points[mid] && points[mid] <= B) {
					findLastIdx = mid;
					start = mid +1;
				}
				else if(A > points[mid]) {
					start = mid +1;
				}
				else {
					end = mid-1;
				}
			}
			
			if(findFirstIdx == -1) {
				System.out.println(0);
			}
			else {
				System.out.println(findLastIdx-findFirstIdx+1);
			}
			
		}
		
		
		
	}
	

}