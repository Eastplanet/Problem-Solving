import java.lang.*;
import java.util.*;

class Solution {
    
    int [][] dp;
    int [][] arr;
    int alHigh, coHigh;
    int N;
    
    int result = Integer.MAX_VALUE;
    public int solution(int alp, int cop, int[][] problems) {
        
        init(alp,cop,problems);
        
        if(alp >= alHigh && cop >= coHigh){
            return 0;
        }
        
        if(alp > alHigh){
            alp = alHigh;
        }
        if(cop > coHigh){
            cop = coHigh;
        }
        
        for(int i=alp;i<=alHigh;i++) {
            for(int j=cop;j<=coHigh;j++) {
                
                int next = i+1;
                if(next >= alHigh){
                    next = alHigh;
                }
                dp[next][j] = Math.min(dp[i][j]+1, dp[next][j]);   
                updateMin(next,j,dp[next][j]);
                
                
                next = j+1;
                if(next >= coHigh){
                    next = coHigh;
                }
                dp[i][next] = Math.min(dp[i][j]+1, dp[i][next]);
                updateMin(i,next,dp[i][next]);
                
                
                for(int k=0;k<N;k++){
                    int[] curr = arr[k];
                    if(i < curr[0] || j < curr[1]) continue;
                    
                    int nextI = Math.min(i+curr[2],alHigh);
                    int nextJ = Math.min(j+curr[3],coHigh);
                    
                    dp[nextI][nextJ] = Math.min(dp[nextI][nextJ], dp[i][j]+curr[4]);
                    updateMin(nextI,nextJ,dp[nextI][nextJ]);
                }
            }
        }
        
        return result;
    }
    
    public void updateMin(int alp, int cop, int val){
        if(alp >= alHigh && cop >= coHigh){
            result = Math.min(result, val);
        }
    }
    
    public void init(int alp, int cop, int[][] problems){
        
        arr = problems;
        N = problems.length;
        for(int i=0 ;i < N; i++ ){
            alHigh = Math.max(arr[i][0], alHigh);
            coHigh = Math.max(arr[i][1], coHigh);
        }
        
        
        dp = new int[alHigh+1][coHigh+1];
        
        for(int i=0;i<=alHigh;i++){
            for(int j=0;j<=coHigh;j++){
                dp[i][j] = Integer.MAX_VALUE;
                if(i <= alp && j <= cop)dp[i][j] = 0;
            }
        }
        
    }
}