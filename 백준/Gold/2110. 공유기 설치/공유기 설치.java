import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {
	
	static int[] arr;
	static int N;
	static int C; 
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		N = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		
		arr = new int[N];
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(in.readLine());
		}
		
		Arrays.sort(arr);
		
		int start = 1;
		int end = 1_000_000_000;
		
		int maxDist = -1;
		
		while(start <= end) {
			int mid = (start+end)/2;
			if(canInstall(mid)) {
				maxDist = Math.max(maxDist, mid);
				start = mid +1;
			}
			else {
				end = mid - 1;
			}
		}
		
		System.out.println(maxDist);
	}
	
	static boolean canInstall(int range) {
		
		int prevWIFI = -1;
		int installCnt = 0;
		for(int i=0;i<N;i++) {
			if(prevWIFI == -1) {
				installCnt++;
				prevWIFI = arr[i];
			}
			else {
				if(arr[i] - prevWIFI >= range) {
					prevWIFI = arr[i];
					installCnt++;
				}
			}
		}
		
		if(installCnt >= C)return true;
		else return false;
	}

}