import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;

public class Main {
	
	static int N;
	static HashSet<Integer> set = new HashSet<>();
	static int[] arr;
	static int[] val = {1,5,10,50};
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(in.readLine());
		arr = new int[4];
		Arrays.fill(arr, N);
		
		back(0,0,0);
		
		System.out.println(set.size());
		
	}
	
	static void back(int count, int sum, int start) {
		
		if(count == N) {
			if(!set.contains(sum)) {
				set.add(sum);
			}
			return;
		}
		
		for(int i=start;i<4;i++) {
			if(arr[i]!=0) {
				arr[i]--;
				back(count +1, sum+val[i],i);
				arr[i]++;
			}
		}
		
		
	}
}