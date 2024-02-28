import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static int N, M, K, A, B, count;
	static int[] Aarr, Barr, vTime;
	static int[] reception, repair;

	static class Customer implements Comparable<Customer>{
		// 고객번호, 도착시간, 이용 접수 창고, 이용 정비 창고
		int num, arriveTime, receptionNum, repairNum;

		public Customer(int num, int arriveTime) {
			this.num = num;
			this.arriveTime = arriveTime;
		}

		@Override
		public int compareTo(Customer o) {
			if(this.arriveTime == o.arriveTime){
				if(this.receptionNum == o.receptionNum) {
					return this.num - o.num;
				}
				else {
					return this.receptionNum - o.receptionNum;
				}
			}
			else {
				return this.arriveTime - o.arriveTime;
			}
		}

		@Override
		public String toString() {
			return "Customer [num=" + num + ", arriveTime=" + arriveTime + ", receptionNum=" + receptionNum
					+ ", repairNum=" + repairNum + "]";
		}
		
		
	}
	
	public static void main(String[] args) throws Exception {
		
		
		int T = Integer.parseInt(in.readLine());
		for (int tc = 1; tc <= T; tc++) {
			init();

			PriorityQueue<Customer> receptQ = new PriorityQueue<>();
			PriorityQueue<Customer> repairQ = new PriorityQueue<>();
			
			for(int i=0;i<K;i++) {
				receptQ.add(new Customer(i+1, vTime[i]));
			}
			
			while(!receptQ.isEmpty()) {
				Customer curr = receptQ.poll();
				int findminTime = Integer.MAX_VALUE;
				int findminIdx = -1;
				boolean isIn = false;
				//바로 들어갈 수 있다면 입장
				for(int i=0;i<N;i++) {
					if(findminTime > reception[i]) {
						findminTime = reception[i];
						findminIdx = i;
					}
					if(curr.arriveTime >= reception[i]) {
						reception[i] = curr.arriveTime + Aarr[i];
						// 접수 종료 시간을 넣어 repair 큐에 넣어줌
						curr.receptionNum = i+1;
						curr.arriveTime = curr.arriveTime + Aarr[i];
						repairQ.add(curr);
						isIn = true;
						break;
					}
				}
				
				if(isIn)continue;
				
				reception[findminIdx] = reception[findminIdx] + Aarr[findminIdx];
				curr.receptionNum = findminIdx +1;
				curr.arriveTime = reception[findminIdx];
				repairQ.add(curr);
			}
			
			
			while(!repairQ.isEmpty()) {
				Customer curr = repairQ.poll();
				
				int findminTime = Integer.MAX_VALUE;
				int findminIdx = -1;
				
				boolean isIn = false;
				//바로 들어갈 수 있다면 입장
				for(int i=0 ; i<M ;i++) {
					if(findminTime > repair[i]) {
						findminTime = repair[i];
						findminIdx = i;
					}
					if(curr.arriveTime >= repair[i]) {
						
						curr.arriveTime = curr.arriveTime + Barr[i];
						repair[i] = curr.arriveTime;
						
						curr.repairNum = i+1;
						if(curr.receptionNum == A && curr.repairNum == B) {
							count += curr.num;
						}
						
						isIn = true;
						break;
					}
				}
				if(isIn)continue;
				
				curr.arriveTime = repair[findminIdx] + Barr[findminIdx];
				repair[findminIdx] = curr.arriveTime;
				curr.repairNum = findminIdx+1;
				if(curr.receptionNum == A && curr.repairNum == B) {
					count += curr.num;
				}
			}
			
			if(count == 0) {
				sb.append("#").append(tc).append(" ").append(-1).append("\n");
			}
			else {
				sb.append("#").append(tc).append(" ").append(count).append("\n");
			}
		}
		System.out.println(sb);
	}

	public static void init() throws Exception {
		StringTokenizer st = new StringTokenizer(in.readLine());
		count = 0;
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		Aarr = new int[N];
		st = new StringTokenizer(in.readLine());
		for (int i = 0; i < N; i++) {
			Aarr[i] = Integer.parseInt(st.nextToken());
		}
		Barr = new int[M];
		st = new StringTokenizer(in.readLine());
		for (int i = 0; i < M; i++) {
			Barr[i] = Integer.parseInt(st.nextToken());
		}
		vTime = new int[K];
		st = new StringTokenizer(in.readLine());
		for (int i = 0; i < K; i++) {
			vTime[i] = Integer.parseInt(st.nextToken());
		}
		
		reception = new int[N];
		repair = new int[M];
	}
}