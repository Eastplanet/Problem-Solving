import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		/**
		 * 1. 폭발 문자열의 시작 문자가 들어오면 bombStack에 넣는다. 2. 폭발 문자열이 완성되면 stack의 상단에서 폭발 문자열 만큼
		 * 삭제한다. 3. bombStack이 만들어지던 도중 폭발 문자열의 시작 문자가 들어오면 추가로 넣는다. 4. bombStack이 만들어지던
		 * 도중 폭발 문자열의 다음 문자도 시작 문자도 아닌 글자가 들어오면 전부뽑아서 문자열에 추가한다.
		 */

		String str = in.readLine();
		String bomb = in.readLine();

		StringBuilder sb = new StringBuilder();
		Stack<Character> bombStack = new Stack<>();

		int nextIdx = 0;

		for (int i = 0; i < str.length(); i++) {

			char c = str.charAt(i);

			if (c == bomb.charAt(0)|| c == bomb.charAt(nextIdx)) {

				bombStack.add(c);
				
				if(c== bomb.charAt(0))nextIdx = 1;
				else nextIdx++;
				
				if (nextIdx == bomb.length()) {
					
					// 큐에서 bomb크기만큼 pop
					for (int j = 0; j < bomb.length(); j++) bombStack.pop();
					nextIdx = 0;

					if(bombStack.isEmpty())continue;

					char top = bombStack.peek();
					for (int j = 0; j < bomb.length(); j++) {
						if (bomb.charAt(j) == top) nextIdx = j+1;
					}
				}


			} else {
				sb.append(stackToStr(bombStack));
				sb.append(c);
				nextIdx=0;
			}
		}

		if(!bombStack.isEmpty()) sb.append(stackToStr(bombStack));
		
		if(sb.length() == 0) {
			System.out.println("FRULA");
		}
		else {
			System.out.println(sb.toString());
		}

		
	}

	static String stackToStr(Stack<Character> stack) {

		List<Character> list = new ArrayList<>();
		while (!stack.isEmpty()) list.add(stack.pop());

		StringBuilder sb = new StringBuilder();
		for (int i = list.size() - 1; i >= 0; i--) {
			sb.append(list.get(i));
		}

		return sb.toString();
	}

}