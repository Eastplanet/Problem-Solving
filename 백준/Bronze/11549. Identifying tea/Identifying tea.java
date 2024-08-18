import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws Exception {

		int answer = Integer.parseInt(in.readLine());
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int answerCnt = 0;
		for(int i=0;i<5;i++) {
			int num = Integer.parseInt(st.nextToken());
			if(num == answer)answerCnt++;
		}
		
		System.out.println(answerCnt);
	}

}