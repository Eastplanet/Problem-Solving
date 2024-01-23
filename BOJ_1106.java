package ps;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_1106 {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        String[] input = in.readLine().split(" ");
        
        int C = Integer.parseInt(input[0]);
        int N = Integer.parseInt(input[1]);
        int[][] arr = new int[21][2];
        
        for(int i=0;i<N;i++) {
        	input = in.readLine().split(" ");
        	arr[i][0] = Integer.parseInt(input[0]);
        	arr[i][1] = Integer.parseInt(input[1]);
        }
        
        
        int[][] dp = new int[21][1001];
        
        //dp [i][j] i도시까지 활용해서 j만큼의 사람을 모으는 비용
        for(int i=0;i<N;i++) {
        	for(int j=0;j<=C;j++) {
        		if(j==0) continue;
        		
        		int cost = arr[i][0];
        		int customer = arr[i][1];
        	
        		
        		
        		if(j-customer < 0) {
        			
        			if(i-1 < 0) {
        				dp[i][j] = cost;
        			}
        			else {
        				dp[i][j] = Math.min(dp[i-1][j], cost);
        			}
        			
        		}
        		else {
        			
        			if(i-1 < 0) {
        				if(j-customer < 0)dp[i][j] = 0 + cost;
        				else {
        					//System.out.println("now i and j" + i+" : "+j);
        					dp[i][j] = dp[i][j-customer] + cost;
        					}
        			}
        			else {
        				if(j-customer < 0)dp[i][j] = Math.min(dp[i-1][j], 0+cost);
        				dp[i][j] = Math.min(dp[i-1][j], dp[i][j-customer]+cost);
        			}
        		}
        		
        		
        	}
        }
        
        
        int min = Integer.MAX_VALUE;
        min = dp[N-1][C];
        System.out.println(min);
        
	}
}
