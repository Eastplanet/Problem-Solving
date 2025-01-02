import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.lang.*;


public class Main {

	public static StringTokenizer st;
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		
		int start = 1;
		int end = N;
		
		// 가장 긴 list를 기록합니다.
		List<Integer> maxLengArr = new ArrayList<>();
		
		// 두번째 숫자를 1~N으로 넣어보며 수를 만드는 makeList를 호출합니다.
		for(int i=1;i<=N;i++) {
			
			List<Integer> ret = makeList(N, i);
			if(ret.size() > maxLengArr.size()) {
				maxLengArr = ret;
			}
		}
		
		System.out.println(maxLengArr.size());
		for(int i=0;i<maxLengArr.size();i++) {
			System.out.print(maxLengArr.get(i));
			System.out.print(" ");
		}
		
	}
	
	// 첫 숫자와 두번째 숫자를 입력받아 규칙에 따라 수를 만들어서 리턴합니다.
	// 예상 시간 복잡도 log(30000)
	public static List<Integer> makeList(int first, int second){
		List<Integer> ans = new ArrayList<>();
		
		ans.add(first);
		ans.add(second);
		
		int tmp = first-second;
		while(tmp >= 0) {
			ans.add(tmp);
			first = second;
			second = tmp;
			tmp = first - second;
		}
		
		return ans;
	}

}