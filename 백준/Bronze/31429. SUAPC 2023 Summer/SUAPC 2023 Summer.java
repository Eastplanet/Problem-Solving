import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int[][] arr = { { 0, 0 }, { 12, 1600 }, { 11, 894 }, { 11, 1327 }, { 10, 1311 }, { 9, 1004 }, { 9, 1178 },
			{ 9, 1357 }, { 8, 837 }, { 7, 1055 }, { 6, 556 }, { 6, 773 } };

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		System.out.println(arr[N][0] + " " + arr[N][1]);
	}

}