import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {

	public static StringTokenizer st;
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String[] arr = {
				"11 A B C D E F G H J L M",
				"9 A C E F G H I L M",
				"9 A C E F G H I L M",
				"9 A B C E F G H L M",
				"8 A C E F G H L M",
				"8 A C E F G H L M",
				"8 A C E F G H L M",
				"8 A C E F G H L M",
				"8 A C E F G H L M",
				"8 A B C F G H L M"
				};
		
		int N = Integer.parseInt(in.readLine());
		System.out.println(arr[N-1]);
		
	}

}