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
		st = new StringTokenizer(in.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N+1];
		for(int i=0;i<=N;i++) {
			arr[i] = i;
		}
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(in.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			int tmp = arr[a];
			arr[a] = arr[b];
			arr[b] = tmp;
		}
		
		for(int i=1;i<=N;i++) {
			System.out.print(arr[i]+" ");
		}
		
		
	}
	
	
	

}