import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map.Entry;

import javax.xml.stream.events.EntityReference;

import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();

	static int N, min;
	static String[] visited = new String[3];
	static HashMap<String, Integer> map;

	public static void main(String[] args) throws Exception {
		
		int T = Integer.parseInt(in.readLine());
		while (T-- > 0) {
			init();
			comb(0);
			System.out.println(min);
		}
	}

	public static void comb(int count) {
		if (count == 3) {
			int res = calcDist(visited);
			if(min > res) {
				min = res;
			}
			return;
		}

		for (Entry<String, Integer> entry : map.entrySet()) {
			String str = entry.getKey();
			int val = entry.getValue();
			
			if(val == 0) {
				continue;
			}
			
			map.replace(str,val-1);
			visited[count] = str;
			comb(count+1);
			map.replace(str,val);
		}
	}
	
	public static int calcDist(String[] arr) {
		
		int sum = 0;
		for(int i=0;i<4;i++) {
			if(arr[0].charAt(i) != arr[1].charAt(i))sum++;
			if(arr[0].charAt(i) != arr[2].charAt(i))sum++;
			if(arr[1].charAt(i) != arr[2].charAt(i))sum++;
		}
		
		return sum;
	}
	
	

	public static void init() throws Exception {
		N = Integer.parseInt(in.readLine());
		StringTokenizer st = new StringTokenizer(in.readLine());
		min = Integer.MAX_VALUE;

		map = new HashMap<>();
		for (int i = 0; i < N; i++) {
			String tmp = st.nextToken();
			if (map.containsKey(tmp)) {
				map.replace(tmp, map.get(tmp) + 1);
			} else {
				map.put(tmp, 1);
			}
		}
	}
}