import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringBufferInputStream;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception{
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			
			int N = Integer.parseInt(in.readLine());
			int[] arr = new int[N];
			StringTokenizer st = new StringTokenizer(in.readLine());
			for(int i=0;i<N;i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			Arrays.sort(arr);
			
			int M = Integer.parseInt(in.readLine());
			st = new StringTokenizer(in.readLine());
			for(int i=0;i<M;i++) {
				int tgt = Integer.parseInt(st.nextToken());
				if(BS(arr,tgt)) {
					System.out.println(1);
				}
				else {
					System.out.println(0);
				}
				
			}
	}
	
	public static boolean BS(int[] arr, int tgt) {
		int start = 0;
		int end = arr.length-1;
		int mid = 0;
		
		while(start <= end) {
			mid = (start + end)/2;
			
			if(arr[mid]==tgt) {
				return true;
			}
			
			if(tgt < arr[mid]) {
				end = mid - 1;
			}
			else {
				start = mid + 1;
			}
		}
		return false;
	}
}