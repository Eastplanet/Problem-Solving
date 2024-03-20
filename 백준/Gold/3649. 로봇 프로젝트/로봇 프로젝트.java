import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws Exception{
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		
		while(true) {
			String tmp = in.readLine();
			if(tmp ==null)break;
			
			
			long x = Integer.parseInt(tmp)*10000000;
			long N = Integer.parseInt(in.readLine());
			long[]arr = new long[(int) N];
			for(int i=0;i<N;i++) {
				arr[i] = Long.parseLong(in.readLine());
			}
			
			Arrays.sort(arr);
			
			
			boolean isFind = false;
			for(int i=0;i<N;i++) {
				long p1 = arr[i];
				
				long val = x - p1;
				if(val < 0) {
					System.out.println("danger");
					isFind =true;
					break;
				}
				else{
					long search = bs(i+1,N-1,val,arr);
					if(search!=-1) {
						if(arr[i] <= search) {
						System.out.println("yes "+ arr[i] +" " +search);
						}
						else {
							System.out.println("yes "+ search +" " +arr[i]);
						}
						isFind=true;
						break;
					}
				}
			}
			
			if(isFind == false) {
				System.out.println("danger");
			}
			
		}
	}
	
	static long bs(long start,long end, long find,long[]arr) {
		
		while(start <= end) {
			int mid = (int) ((start+end)/2);
			if(arr[mid]==find) {
				return arr[mid];
			}
			
			if(arr[mid] > find) {
				end = mid -1;
			}
			else {
				start = mid + 1;
			}
		}
		
		return -1;
	}
}