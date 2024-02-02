import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static StringBuilder sb =new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(in.readLine());
		
		N = Integer.parseInt(in.readLine());
		
		ArrayList<Integer> arr =new ArrayList<>();
		rec(0,arr);
		
		System.out.println(sb);
	}
	
	
	public static void rec(int cnt, ArrayList<Integer> arr) {
		
		if(cnt == N) {
			long num = 0;
			long k = 1;
			for(int j=arr.size()-1; j >= 0;j--) {
				num += arr.get(j)*k;
				k*=10;
			}
	
			
			sb.append(num).append("\n");
			
			return;
		}
		
		for(int i=1;i<=9;i++) {
			
			if(arr.isEmpty()) {
				if(i==1)continue;
				if(check(i) == false)continue;
				arr.add(i);
				rec(cnt+1,arr);
				arr.remove(arr.size()-1);
			}
			else {
				long num = 0;
				long k = 1;
				for(int j=arr.size()-1; j >= 0;j--) {
					num += arr.get(j)*k;
					k*=10;
				}
				
				num *= 10;
				num += i;
				if(check(num)==false)continue;
				arr.add(i);
				rec(cnt+1,arr);
				arr.remove(arr.size()-1);
			}
		}
	}
	
	public static boolean check(long num) {
		for(int i=2;i*i <= num;i++) {
			if(num%i == 0)return false;
		}
		return true;
	}
	
}