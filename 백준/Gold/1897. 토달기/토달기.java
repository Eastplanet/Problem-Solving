import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {

	public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	public static StringTokenizer st;
	
	public static int d, maxLength;
	public static String[] words;
	public static Map<String,Integer> map;
	public static String maxLengthWord, answer;
	
	public static void main(String[] args) throws Exception {
		
		init();
		
		for(int i=0;i<d;i++) {
			BFS(words[i]);
		}
		
		System.out.println(maxLengthWord);
	}
	
	// word 단어부터 BFS를 수행한다.
	// word를 구성하는 하나를 지운 뒤, 해당 단어가 set에 존재하면 방문
	// answer 단어라면 기억
	public static void BFS(String word) {
		boolean[] visited = new boolean[d];
		
		Queue<String> q = new ArrayDeque<>();
		visited[map.get(word)] = true;
		q.add(word);
		
		while(!q.isEmpty()) {
			String curr = q.poll();
			
			if(curr.equals(answer)) {
				if(maxLengthWord.length() <word.length()) {
					maxLengthWord = word;
				}
				return;
			}
			
			// i번을 지운 단어가 map에 존재하는 지 확인
			for(int i=0;i<curr.length();i++) {
				String front = curr.substring(0, i);
				String back = curr.substring(i+1,curr.length());
				
				String next = front+back;
				if(map.containsKey(next)) {
					int idx = map.get(next);
					if(visited[idx]) {
						continue;
					}
					
					visited[idx] = true;
					q.add(next);
				}
			}
		}
	}
	
	public static void init() throws Exception{
		
		st = new StringTokenizer(in.readLine());
		
		d = Integer.parseInt(st.nextToken());
		answer = st.nextToken();
		
		words = new String[d];
		map = new HashMap<>();
		
		for(int i=0;i<d;i++) {
			words[i] = in.readLine();
			map.put(words[i],i);
		}
		
		maxLengthWord = answer;
	}
	
	

	

}