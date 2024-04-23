import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		
		Box[] boxs = new Box[N];
		for(int i=0;i<N;i++) {
			StringTokenizer st  =new StringTokenizer(in.readLine());
			int b = Integer.parseInt(st.nextToken());
			int h  = Integer.parseInt(st.nextToken());
			int w  = Integer.parseInt(st.nextToken());
			
			boxs[i] = new Box(b, h, w,i+1);
		}
		
		Arrays.sort(boxs);
		
		
		
		int[] curHei = new int[N];
		int[] prev = new int[N];
		for(int i=0;i<N;i++) {
			curHei[i] = boxs[i].hei;
			prev[i] = -1;
		}
		
		
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<i;j++) {
				
				if(boxs[j].wei > boxs[i].wei) {
					if(curHei[i] < curHei[j] + boxs[i].hei) {
						curHei[i] = curHei[j] + boxs[i].hei;
						prev[i] = j;
					}
					
				}
			}
		}
		
		
		int max = 0;
		int maxIdx = 0;
		for(int i=0;i<N;i++) {
			
			if(max < curHei[i]) {
				max = curHei[i];
				maxIdx = i;
			}
			
		}
		
		
		List<Integer> ruot = new ArrayList<>();
		int now = maxIdx;
		
		while(now != -1) {
			
			ruot.add(boxs[now].num);
			now = prev[now];
			
		}
		
		System.out.println(ruot.size());
		for(int i=0;i<ruot.size();i++) {
			System.out.println(ruot.get(i));
		}
		
	}

	
	static class Box implements Comparable<Box>{
		int num;
		int bot,hei,wei;
		public Box(int bot, int hei, int wei,int num) {
			super();
			this.bot = bot;
			this.hei = hei;
			this.wei = wei;
			this.num = num;
		}
		@Override
		public int compareTo(Box o) {
			return o.bot- this.bot;
		}
		@Override
		public String toString() {
			return "Box [num=" + num + ", bot=" + bot + ", hei=" + hei + ", wei=" + wei + "]";
		}
		
	}
}