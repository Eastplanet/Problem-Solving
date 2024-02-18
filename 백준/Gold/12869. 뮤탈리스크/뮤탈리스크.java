import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	
	static int min = Integer.MAX_VALUE;
	static int[][][] visit = new int[61][61][61];
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(in.readLine());
		ArrayList<Integer>scv = new ArrayList<>();
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		for(int i=0;i<N;i++) {
			scv.add(Integer.parseInt(st.nextToken()));
		}
		
		ArrayList<Integer>tmp1 = new ArrayList<>();
		tmp1.add(0);
		tmp1.add(0);
		tmp1.add(0);
		
		for(int i=0;i<61;i++) {
			for(int j=0;j<61;j++) {
				Arrays.fill(visit[i][j], Integer.MAX_VALUE);
			}
		}
		
		back(scv,tmp1,0);
		
		System.out.println(min);
		
		
	}
	
	public static void back(ArrayList<Integer> scv,ArrayList<Integer>hit, int hitCount) {
		
		
		
		
		if(hitCount >= min) {
			return;
		}
		
		ArrayList<Integer>tmp = new ArrayList<>();
		for(int i=0;i<scv.size();i++) {
			
			//공격을 받고 살아있는 경우 tmp에 삽입
			if(scv.get(i)-hit.get(i) > 0) {
				tmp.add(scv.get(i)-hit.get(i));
			}
		}
		
		
		//다 죽은 경우
		if(tmp.size()==0) {
			if(min > hitCount) {
				min = hitCount;
			}
			
			return;
		}
		
		ArrayList<Integer> sortCheck = (ArrayList<Integer>) tmp.clone();
		Collections.sort(sortCheck);
		
		int[] sorttmp = new int[3];
		
		for(int i=0;i<sortCheck.size();i++) {
			sorttmp[i]=sortCheck.get(i);
		}
		
		if(visit[sorttmp[0]][sorttmp[1]][sorttmp[2]] <= hitCount) {
			return;
		}
		
		//제일 처음 무시
		if(hit.get(0) != 0) {
			visit[sorttmp[0]][sorttmp[1]][sorttmp[2]] = hitCount;
		}
		
		
		
		
		int[] damage = {9,3,1};
		
		if(tmp.size() == 3) {
			
			// 9 3 1 , 9 1 3 , 순열 생성
			for(int i=0;i<3;i++) {
				for(int j=0;j<3;j++) {
					if(i==j)continue;
					for(int k=0;k<3;k++) {
						
						
						
						
						if(i==k || j==k)continue;
						
						
						ArrayList<Integer> hitTmp = new ArrayList<>();
						
						hitTmp.add(damage[i]);
						hitTmp.add(damage[j]);
						hitTmp.add(damage[k]);
						back(tmp,hitTmp,hitCount+1);
						
						
					}
				}
			}
			
			
		}
		else if(tmp.size() == 2) {
			
			ArrayList<Integer> hitTmp = new ArrayList<>();
			hitTmp.add(damage[0]);
			hitTmp.add(damage[1]);
			back(tmp,hitTmp,hitCount+1);
			
			hitTmp.clear();
			hitTmp.add(damage[1]);
			hitTmp.add(damage[0]);
			back(tmp,hitTmp,hitCount+1);
			
		}
		else {
			ArrayList<Integer> hitTmp = new ArrayList<>();
			hitTmp.add(9);
			back(tmp,hitTmp,hitCount+1);
		}
		
		
		
	}
}