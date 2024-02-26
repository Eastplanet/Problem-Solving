import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static class Prj implements Comparable<Prj>{
		int start,end;
		public Prj(int start, int end) {
			super();
			this.start = start;
			this.end = end;
		}
		@Override
		public int compareTo(Prj o) {
			return o.end - this.end;
		}
	}
					   //  0   1   2  3    4   5   6   7   8   9  10  11  12
	static int[] month = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(in.readLine());
		Prj[] projects = new Prj[N];
		int[] visit = new int[N];
		
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			int startm = Integer.parseInt(st.nextToken());
			int startd = Integer.parseInt(st.nextToken());
			int startN = monToDate(startm, startd);
			
			int endm = Integer.parseInt(st.nextToken());
			int endd = Integer.parseInt(st.nextToken());
			int endN = monToDate(endm, endd);
			
			projects[i] = new Prj(startN, endN);
		}
		
		Arrays.sort(projects);
		
		//3월 1일부터 참여해야한다.
		int now = monToDate(3, 1);
		// 적어도 12월 1일에 끝나는 프로젝트를 해야함
		int end = monToDate(12, 1);
		int prjCount = 0;
		
		while(true) {
			if(now >= end) {
				break;
			}
			
			boolean findFlag = true;
			//10만 * 365 = 1억 미만
			for(int i=0;i<N;i++) {
				if(visit[i]==1)continue;
				Prj curr = projects[i];
				// 작거나 같다.             2월2일에 참여하기 위해선 프로젝트가 2월 3일에 끝나야함
				if(curr.start <= now && curr.end > now) {
					prjCount++;
					now = curr.end;
					visit[i]=1;
					findFlag = false;
				}
				
			}
			
			//할 수 있는 프로젝트가 없음
			if(findFlag) {
				System.out.println(0);
				return;
			}
		}
		
		System.out.println(prjCount);
		
		
		
		
	}
	
	
	
	//1월 1일 = 1 , 2월 1 일 = [1월일자] + 1 = 32
	public static int monToDate(int mon, int day) {
		int sum = 0;
		for(int i=0;i<mon;i++) {
			sum+=month[i];
		}
		return sum + day;
	}
}