import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws Exception {

		StringTokenizer st = new StringTokenizer(in.readLine());
		int year = Integer.parseInt(st.nextToken());
		int month = Integer.parseInt(st.nextToken());
		int day = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(in.readLine());
		int yyear = Integer.parseInt(st.nextToken());
		int mmonth = Integer.parseInt(st.nextToken());
		int dday = Integer.parseInt(st.nextToken());
		
		if((year < yyear) && (month < mmonth || (month == mmonth && day <= dday))) {
			System.out.println(yyear - year);
		}
		else if(year == yyear){
			System.out.println(yyear - year);
		}
		else {
			System.out.println(yyear - year - 1);
		}
		
		System.out.println(yyear - year + 1);
		
		if(year == yyear) {
			System.out.println(0);
		}
		else {
			System.out.println(yyear - year);
		}
		
	}

}