import java.util.*;
import java.lang.*;


class Solution {
    
    int minLevel = Integer.MAX_VALUE;
    int arrSize;
    
    public int solution(int[] diffs, int[] times, long limit) {
        
        arrSize = diffs.length;
        int start = 1;
        int end = 100000;
        
        while(start <= end){
            int mid = (start + end) / 2;
            
            if(canPass(diffs,times,mid,limit)){
                end = mid - 1;
                minLevel = Math.min(minLevel, mid);
            }
            else{
                start = mid + 1;
            }
        }
        
        return minLevel;
    }
    
    public boolean canPass(int[] diffs, int[] times, int level, long limit){
        
        // System.out.println("숙련도  : "+level + " limit : " + limit);
        
        
        long spendTime = 0;
        for(int i=0;i<arrSize;i++){
            spendTime += calcTime(level, diffs, times, i);
            // System.out.println(i+ "번 문제 해결시 총 소요 : " + spendTime);
            if(spendTime > limit){
                // System.out.println("시간이 너무 많이 소요됨!");
                return false;
            }
        }
        // System.out.println("성공!");
        return true;
    }
    
    
    public long calcTime(int level, int[] diffs, int[] times, int problemIdx){
        
        int nowDiff = diffs[problemIdx];
        int nowTime = times[problemIdx];
        
        if(level >= nowDiff){
            return nowTime;
        }
        
        // 문제를 실패하는 경우
        long sum = 0;
        
        int skillDif = nowDiff - level;
        
        // 첫문제면 이전 문제를 풀지 않아도 된다.
        if(problemIdx == 0){
            sum = (skillDif) * nowTime;
            sum += nowTime;
        }
        else{
            sum = (skillDif) * (nowTime + times[problemIdx-1]);
            sum += nowTime;
        }
        
        return sum;
        
    }
}