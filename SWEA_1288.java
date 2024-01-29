package ps;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SWEA_1288 {
	
	public static void main(String[] args) throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(in.readLine());
		
		
		for(int i=1;i<=N;i++) {
			int num = Integer.parseInt(in.readLine());
			
			int answerMasking = (1<<10)-1;
			int visited = 0;
			
			int count = 1;
			while(true) {
				int val = num*count;
				String sVal = Integer.toString(val);
				
				for(int j=0;j<sVal.length();j++) {
					int c = sVal.charAt(j) - '0';
					visited = visited | (1 << c);
				}
				
				//if( (visited ^ answerMasking) == 0){
				if( visited  == answerMasking) {
					sb.append("#"+i+" "+num*count+"\n");
					break;
				}
				
				count++;
			}
		}
		System.out.println(sb);
	}
}
