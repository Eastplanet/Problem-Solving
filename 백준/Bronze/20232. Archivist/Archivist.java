import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static StringTokenizer st;
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws Exception {

		String tmp = 
				"1995: ITMO\r\n" + 
				"1996: SPbSU\r\n" + 
				"1997: SPbSU\r\n" + 
				"1998: ITMO\r\n" + 
				"1999: ITMO\r\n" + 
				"2000: SPbSU\r\n" + 
				"2001: ITMO\r\n" + 
				"2002: ITMO\r\n" + 
				"2003: ITMO\r\n" + 
				"2004: ITMO\r\n" + 
				"2005: ITMO\r\n" + 
				"2006: PetrSU, ITMO\r\n" + 
				"2007: SPbSU\r\n" + 
				"2008: SPbSU\r\n" + 
				"2009: ITMO\r\n" + 
				"2010: ITMO\r\n" + 
				"2011: ITMO\r\n" + 
				"2012: ITMO\r\n" + 
				"2013: SPbSU\r\n" + 
				"2014: ITMO\r\n" + 
				"2015: ITMO\r\n" + 
				"2016: ITMO\r\n" + 
				"2017: ITMO\r\n" + 
				"2018: SPbSU\r\n" + 
				"2019: ITMO";
		String[] arr = tmp.split("\n");
		int N = Integer.parseInt(in.readLine());
		N = N-1995;
		
		String a = arr[N].split(":")[1].split("\r")[0];
		for(int i=1;i<a.length();i++) {
			System.out.print(a.charAt(i));
		}
	}

}