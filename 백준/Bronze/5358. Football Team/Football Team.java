import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		while(true) {
			String tmp = in.readLine();
			if(tmp == null)break;
			
			for(int i=0;i<tmp.length();i++) {
				if(tmp.charAt(i)=='i') {
					System.out.print('e');
				}
				else if(tmp.charAt(i)=='e') {
					System.out.print('i');
				}
				else if(tmp.charAt(i)=='I') {
					System.out.print('E');
				}
				else if(tmp.charAt(i)=='E') {
					System.out.print('I');
				}
				else {
					System.out.print(tmp.charAt(i));
				}
				
			}
			System.out.println();
		}
	}
	
}