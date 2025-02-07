import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

import javax.sound.midi.MidiUnavailableException;

public class Main {

	public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	public static StringTokenizer st;
	
	
	public static void main(String[] args) throws Exception {
//		st = new StringTokenizer(in.readLine());
		
		int N = Integer.parseInt(in.readLine());
		
		if(N%3 == 0) {
			System.out.println("S");
		}
		else if(N % 3 == 1) {
			System.out.println("U");
		}
		else {
			System.out.println("O");
		}
		
		
	}
	
	
	

}