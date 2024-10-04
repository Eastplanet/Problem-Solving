import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {

	static StringTokenizer st;
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

	static int N;
	
	public static void main(String[] args) throws Exception {

		N = Integer.parseInt(in.readLine());
		
		for(int i=0;i<N;i++) {
			
			String tmp = in.readLine();
			int[] arr = new int[26];
			
			for(int j=0;j<tmp.length();j++) {
				if('a' <= tmp.charAt(j) && tmp.charAt(j)<='z') {
					arr[tmp.charAt(j)-'a'] =1;
				}
				else if('A' <= tmp.charAt(j) && tmp.charAt(j)<='Z') {
					arr[tmp.charAt(j)-'A'] = 1;
				}
			}
			
			StringBuilder sb = new StringBuilder();
			
			boolean check = false;
			
			for(int j=0;j<26;j++) {
				if(arr[j] == 0) {
					check = true;
					sb.append((char)('a'+j));
				}
			}
			if(check) {
				System.out.println("missing "+sb.toString());
			}
			else {
				System.out.println("pangram");
			}
		}
	}

}