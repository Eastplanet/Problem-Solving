import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	public static StringTokenizer st;
	public static int[] arr;
	
	public static void main(String[] args) throws Exception {
		
		arr = new int[1<<15];
		
		int size = (int)Math.sqrt(1<<15)+1;
		
		for(int i=1;i<=size;i++) {
			
			int num = i*i;
			checkAndCnt(num);
			
			
			for(int j=i;j<=size;j++) {
				
				num = i*i + j*j;
				checkAndCnt(num);
				
				for(int k=j;k<=size;k++) {
					
					num = i*i + j*j + k*k;
					checkAndCnt(num);
					
					for(int l=k;l<=size;l++) {
						
						num = i*i + j*j + k*k + l*l;
						checkAndCnt(num);
					}
				}
			}
		}
		
		
		while(true) {
			int N = Integer.parseInt(in.readLine());
			
			if(N==0) {
				break;
			}
			
			System.out.println(arr[N]);
		}
	}
	
	public static void checkAndCnt(int num) {
		if(num < 1<<15) {
			arr[num]++;
		}
	}

}