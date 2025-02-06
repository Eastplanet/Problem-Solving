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
	
	public static int N,K;
	public static int[] arr;
	
	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(in.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		st = new StringTokenizer(in.readLine());
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int start = 1;
		int end = 1_000_000_000;
		
		int minPrice = 1_000_000_000;
		
		while(start <= end) {
			int mid = (start+end)/2;
			if(canAccept(mid)) {
				end = mid - 1;
				minPrice = Math.min(mid,minPrice);
			}
			else {
				start = mid + 1;
			}
		}
		
		System.out.println(minPrice);
		
		
	}
	
	public static boolean canAccept(int price) {
		
		int combo = 0;
		for(int i=0;i<N;i++) {
			if(arr[i] > price) {
				combo++;
				if(combo >= K) {
					return false;
				}
			}
			else {
				combo = 0;
			}
		}
		
		return true;
	}
	

}