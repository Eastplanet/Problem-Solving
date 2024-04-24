import java.lang.*;
import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        
        Arrays.sort(targets,(a1,a2)->a1[1]-a2[1]);
        
        int cnt = 0;
        int prev = 0;
        for(int i=0;i<targets.length;i++){
            if(i==0 || targets[i][0] >= prev){
                cnt++;
                prev = targets[i][1];
            }
        }
        
        return cnt;
    }
}