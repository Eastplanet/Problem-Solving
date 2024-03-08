import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int[] arr = new int[31];
		for(int i=0;i<28;i++) {
			arr[Integer.parseInt(in.readLine())]=1;
		}
		
		for(int i=1;i<=30;i++) {
			if(arr[i] == 0) {
				System.out.println(i);
			}
		}
	}
}