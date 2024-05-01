import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(in.readLine());
		while (T-- > 0) {

			int N = Integer.parseInt(in.readLine());
			Set<String> banSet = new HashSet<>();
			Set<String> realSet = new HashSet<>();
			boolean okFlag = true;

			String[] numList = new String[N];
			for (int i = 0; i < N; i++) {
				numList[i] = in.readLine();
			}

			for (int i = 0; i < N; i++) {
				// 1234가 일관성이 있는지 확인
				String num = numList[i];

				// 1. 1234가 banSet에 포함되어있는지 확인 ( ex. 12345에 의해 1234가 못들어감 )
				if (banSet.contains(num)) {
					okFlag = false;
				}

				// 2. 1, 12, 123, 1234(두 전화번호가 같은 겨우는 없긴 함) 라는 숫자가 realSet에 포함되어 있는지 확인 ( ex.
				// 1234에 의해 1,12,123이 못들어감 )
				String[] list = partition(num);
				for (String item : list) {
					if (realSet.contains(item)) {
						okFlag = false;
					}
				}

				if (okFlag == false) {
					break;
				}
				
				// banSet에 1,12,123,1234 넣기, realSet에 1234넣기
				for (String item : list) {
					banSet.add(item);
				}
				realSet.add(num);

			}

			if (okFlag) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		}

	}

	// 1234가 들어오면 [1, 12, 123, 1234]로 나눠준다.
	static String[] partition(String num) {
		
		String[] result = new String[num.length()];
		
		for (int i = 0; i < num.length(); i++) {
			result[i] = num.substring(0, i+1);
		}

		return result;
	}
}