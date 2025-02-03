import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	public static StringTokenizer st;

	public static int N, Q, C;
	public static int[] pageSize;

	public static class Browser {
		
		int[] frontSpace;
		int frontIdx;
		int frontBaseIdx;
		
		int[] backSpace;
		int backIdx;
		int backBaseIdx;
		
		int currentPage;
		
		int currentCache;
		int backCache;
		int frontCache;
		
		int maxCache;

		public Browser(int C) {
			
			/*
			 * List를 사용하여 frontSpace를 관리하면 삭제 시 실제 요소를 삭제해야한다.
			 * 배열과 frontIdx를 사용하여 삭제시 frontIdx -1 처리를 하면 삭제 효과를 볼 수 있다.
			 * 공간은 더 사용
			 */
			this.frontSpace = new int[10000];
			this.frontIdx = 0;
			// baseIdx 는 가장 오래된 페이지를 삭제할 때 실제로 삭제하지 않고 삭제 처리를 하는 최적화를 위한 변수
			this.frontBaseIdx = 0;
			
			this.backSpace = new int[10000];
			this.backIdx = 0;
			this.backBaseIdx = 0;
			
			this.currentPage = -1;
			
			this.currentCache = 0;
			this.backCache = 0;
			this.frontCache = 0;
			
			this.maxCache = C;
		}

		private void command(String cmdLine) {
			
			st = new StringTokenizer(cmdLine);
			String cmd = st.nextToken();

			if (cmd.equals("B")) {
				back();
			} else if (cmd.equals("F")) {
				front();
			} else if (cmd.equals("A")) {
				int num = Integer.parseInt(st.nextToken());
				access(num);
			} else if (cmd.equals("C")) {
				compress();
			}
		}
		
		private void back() {
			
			if(backIdx != backBaseIdx) {
				// 현재 보고 있던 페이지를 앞으로 공간에 저장
				frontSpace[frontIdx] = currentPage;
				frontCache += pageSize[currentPage];
				frontIdx++;
				
				// 뒤로가기 공간에서 최근의 페이지를 접속
				currentPage = backSpace[backIdx-1];
				backIdx--;
				currentCache = pageSize[currentPage];
				backCache -= currentCache;
				
			}
		}
		
		private void front() {
			
			if(frontIdx != frontBaseIdx) {
				// 현재보고 있는 페이지를 뒤로가기 공간에 저장
				backSpace[backIdx] = currentPage;
				backCache += pageSize[currentPage];
				backIdx++;
				
				// 앞으로가기 공간에서 최근의 페이지를 접속
				currentPage = frontSpace[frontIdx-1];
				frontIdx--;
				currentCache = pageSize[currentPage];
				frontCache -= currentCache;
			}
		}
		
		private void access(int nextPage) {
			
			// 앞으로 가기 공간 삭제
			frontIdx = frontBaseIdx;
			frontCache = 0;
			
			// 현재 페에지를 뒤로 가기 공간에 추가
			// 첫 실행이 아닌 경우에만 동작
			if(currentPage != -1) {
				
				backSpace[backIdx] = currentPage;
				backIdx++;
				backCache += currentCache;
			}
			
			// 다음 접속할 페이지를 현재 페이지로 갱신
			currentPage = nextPage;
			currentCache = pageSize[currentPage];
			
			// 최대 용량이 초과하면 뒤로가기 공간에서 가장 오래된 페이지를 삭제한다.
			while(currentCache + backCache + frontCache > maxCache) {
				backCache -= pageSize[backSpace[backBaseIdx]];
				backBaseIdx++;
			}
			
		}
		
		private void compress() {
			
			List<Integer> tmpList = new ArrayList<>();
			
			int prevPage = -2;
			
			for(int i=backBaseIdx;i<backIdx;i++) {
				
				int nowPage = backSpace[i];
				
				
				if(prevPage == nowPage) {
					continue;
				}
				
				tmpList.add(nowPage);
				prevPage = nowPage;
			}
			
			backCache = 0;
			backBaseIdx = 0;
			backIdx = 0;
			for(int i=0;i<tmpList.size();i++) {
				backSpace[i] = tmpList.get(i);
				backCache += pageSize[backSpace[i]];
				backIdx++;
			}
			
		}
		
		public void print() {
			System.out.println(currentPage);
			
			if(backBaseIdx == backIdx) {
				System.out.println(-1);
			}
			else {
				for(int i=backIdx-1;i>=backBaseIdx;i--) {
					
					System.out.print(backSpace[i]+" ");
					
				}
				System.out.println();
			}
			
			
			
			if(frontBaseIdx == frontIdx) {
				System.out.println(-1);
			}
			else {
				for(int i=frontIdx-1;i>=frontBaseIdx;i--){
					
					System.out.print(frontSpace[i]+" ");
					
				}
			}
		}
	}

	public static void main(String[] args) throws Exception {

		init();
		
		Browser browser = new Browser(C);

		for (int i = 0; i < Q; i++) {
			String cmd = in.readLine();
			browser.command(cmd);
		}
		
		browser.print();
		
	}

	public static void init() throws Exception {
		st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		Q = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		pageSize = new int[10000];

		st = new StringTokenizer(in.readLine());
		for (int i = 1; i <= N; i++) {
			pageSize[i] = Integer.parseInt(st.nextToken());
		}
	}

}