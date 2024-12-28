import java.util.*;
import java.lang.*;

class Solution {
    public long solution(int r1, int r2) {
        
        return retDotCnt(r1,r2);
    }
    
    // 반지름 r을 받아 해당 원 내부의 점 개수를 리턴
    public long retDotCnt(int r1, int r2) {
        
        long totalDot = 0;
        
        for(int i=1;i<=r2;i++){
            double y1 = Math.sqrt(Math.pow(r1,2)-Math.pow(i,2));
            double y2 = Math.sqrt(Math.pow(r2,2)-Math.pow(i,2));
            totalDot += (long)y2 - (long)Math.ceil(y1) + 1;
         }
        
        return totalDot * 4 ;
    }
}