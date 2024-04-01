import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(in.readLine());
		while (T-- > 0) {
			int cmd = Integer.parseInt(in.readLine());

			TreeMap<Integer, Integer> map = new TreeMap<>();

			while (cmd-- > 0) {
				StringTokenizer st = new StringTokenizer(in.readLine());
				char c = st.nextToken().charAt(0);
				int n = Integer.parseInt(st.nextToken());

				if (c == 'I') {
					if (map.containsKey(n)) {
						map.put(n, map.get(n) + 1);
					} else {
						map.put(n, 1);
					}
				} else {
					if (n == 1) {
						if (!map.isEmpty()) {

							int val = map.lastEntry().getValue();
							val--;
							if (val == 0) {
								map.pollLastEntry();
							} else {
								map.put(map.lastEntry().getKey(), val);
							}

						}

					} else {
						if (!map.isEmpty()) {
							int val = map.firstEntry().getValue();
							val--;
							if (val == 0) {
								map.pollFirstEntry();
							} else {
								map.put(map.firstEntry().getKey(), val);
							}
						}
					}
				}
			}

			if (map.isEmpty()) {
				System.out.println("EMPTY");
			} else {
				System.out.println(map.lastKey() + " " + map.firstKey());
			}

		}
	}
}