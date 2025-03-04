import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	public static StringTokenizer st;
	public static int N, Q;
	public static int[][] arr;
	public static int[][] qarr;
	public static List<Food> foods;

	public static void main(String[] args) throws Exception {
		
		input();
		Collections.sort(foods, (Food f1, Food f2)->{
			return f1.maeun - f2.maeun;
		});
		
		for(int i=0;i<Q;i++){
			int u = qarr[i][0];
			int v = qarr[i][1];
			int x = qarr[i][2];
			int y = qarr[i][3];
			
			int[] range = findRange(u,v);
			
			if(range[0] == Integer.MAX_VALUE) {
				System.out.println(0);
				continue;
			}
			
			int cnt = 0;
			
			for(int a=range[0];a<=range[1];a++) {
				if((x <= foods.get(a).dan) && (foods.get(a).dan <= y)) {
					cnt++;
				}
			}
			
			System.out.println(cnt);
		}
		
	}
	
	public static int[] findRange(int lower, int upper) {
		int[] range = new int[2];
		range[0] = Integer.MAX_VALUE;
		range[1] = Integer.MIN_VALUE;
		
		//lower 를 기준으로 lower_bound 해당 값 혹은 그거보다 높은  값, upper보다는 낮아야 함.
		int start = 0;
		int end = N-1;
		
		while(start <= end) {
			int mid = (start+end) / 2;
			if(foods.get(mid).maeun >= lower) {
				range[0] = Math.min(range[0], mid);
				end = mid - 1;
			}
			else {
				start = mid + 1;
			}
		}
		
		start = 0;
		end = N-1;
		
		//upper 를 기준으로 upper_bound 해당 값 혹은 그거보다 낮은  값, lower보다는 높아야 함.
		while(start <= end) {
			int mid = (start+end) / 2;
			if(foods.get(mid).maeun <= upper) {
				range[1] = Math.max(range[1], mid);
				start = mid + 1;
			}
			else {
				end = mid - 1;
			}
		}
		
		return range;
	}

	public static void input() throws Exception {
		st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		Q = Integer.parseInt(st.nextToken());
		
		foods = new ArrayList<>();
		arr = new int[N][2];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			arr[i][0] = a;
			arr[i][1] = b;
			foods.add(new Food(a,b,i));
		}
		
		qarr = new int[Q][4];

		for (int i = 0; i < Q; i++) {
			st = new StringTokenizer(in.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			qarr[i][0] = a;
			qarr[i][1] = b;
			qarr[i][2] = c;
			qarr[i][3] = d;
		}
		
	}
	
	public static class Food{
		int maeun,dan,idx;
		public Food(int maeun,int dan,int idx) {
			this.maeun = maeun;
			this.dan = dan;
			this.idx = idx;
		}
	}

}