package ps;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_10726 {
	
	public static void main(String[] args) throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int TC = Integer.parseInt(in.readLine());
		for(int testCase = 1 ; testCase <= TC ; testCase ++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			int M = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
			
			int answerBit = (1<<M) - 1;
			if((N & answerBit) == answerBit) {
				sb.append("#"+testCase+" ON\n");
			}
			else {
				sb.append("#"+testCase+" OFF\n");
			}
		}
		
		System.out.println(sb);
	}
}
