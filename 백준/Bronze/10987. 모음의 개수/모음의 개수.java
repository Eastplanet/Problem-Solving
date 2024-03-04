import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String tmp = in.readLine();
		
		char[]arr = {'i','e','a','o','u'};
		
		int count = 0;
		for(int i=0;i<tmp.length();i++) {
			for(int j=0;j<arr.length;j++) {
				if(tmp.charAt(i) == arr[j])count++;
			}
		}
		
		System.out.println(count);
	}
}