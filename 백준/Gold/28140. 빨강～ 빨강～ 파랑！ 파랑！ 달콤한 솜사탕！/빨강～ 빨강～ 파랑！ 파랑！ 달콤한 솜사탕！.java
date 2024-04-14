import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static List<Integer> rList = new ArrayList<>();
	static List<Integer> bList = new ArrayList<>();
	static int N;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		int Q = Integer.parseInt(st.nextToken());

		String str = in.readLine();
		for (int i = 0; i < str.length(); i++) {
			if(str.charAt(i) == 'R') {
				rList.add(i);
			}
			else if(str.charAt(i)=='B') {
				bList.add(i);
			}
		}
		
		
		for(int i=0;i<Q;i++) {
			st= new StringTokenizer(in.readLine());
			int l = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());
			
			if(rList.size() == 0 || bList.size() == 0) {
				sb.append("-1").append("\n");
				continue;
			}
			
			int redFirstIdx = binarySearch_UpperBound(l, rList);
			int redSecondIdx = redFirstIdx + 1;
			if(redFirstIdx == -1 || redFirstIdx == rList.size()-1) {
				sb.append("-1").append("\n");
				continue;
			}
			
			int redFirstVal = rList.get(redFirstIdx);
			int redSecondVal = rList.get(redSecondIdx);
			
			if(!(redFirstVal >= l && redFirstVal <= r) || !(redSecondVal >= l && redSecondVal <= r)) {
				sb.append("-1").append("\n");
				continue;
			}
			
			
			
			int blueFirstIdx = binarySearch_UpperBound(redSecondVal, bList);
			int blueSecondIdx = blueFirstIdx + 1;
			if(blueFirstIdx == -1 || blueFirstIdx == bList.size()-1) {
				sb.append("-1").append("\n");
				continue;
			}
			
			int blueFirstVal = bList.get(blueFirstIdx);
			int blueSecondVal = bList.get(blueSecondIdx);
			
			if(!(blueFirstVal >= l && blueFirstVal <= r) || !(blueSecondVal >= l && blueSecondVal <= r)) {
				sb.append("-1").append("\n");
				continue;
			}
			
			
			
			sb.append(redFirstVal+" "+redSecondVal+" ").append(blueFirstVal+" "+blueSecondVal+" ").append("\n");
		}
		System.out.println(sb);
	}
	
	static int binarySearch_UpperBound(int bound, List<Integer> list) {
		int result = Integer.MAX_VALUE;
		
		int start = 0;
		int end = list.size()-1;
		while(start <= end) {
			int mid = (start + end)/  2;
			
			if(list.get(mid) >= bound) {
				end = mid - 1;
				result = Math.min(result, mid);
			}
			else {
				start = mid + 1;
			}
		}
		
		if(result == Integer.MAX_VALUE)result = -1;
		return result;
	}
}