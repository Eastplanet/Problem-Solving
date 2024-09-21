import java.lang.*;
import java.util.*;

class Solution {
    // 전체 배열
    long[] arr;
    // 누적합
    long[] hap;
    // 배열 길이
    int N, fullSize;
    long everyItemSum;
    
    int minCmdCount = Integer.MAX_VALUE;
    
    boolean debugMode = false;
    
    public int solution(int[] queue1, int[] queue2) {
        
        init(queue1, queue2);
        
        // 처음부터 같은 경우 스킵
        if(getRangeSum(0,N-1) == getRangeSum(N,fullSize-1)){
            return 0;
        }
        
        
        for(int i=0;i<fullSize;i++){
            
            if(i == 2){
                System.out.println("BS 시작  -- ");
                debugMode = true;
            }
            BS(i);
            if(i == 2){
                System.out.println("BS 끝  --");
                debugMode = false;
            }
        }
        
        if(minCmdCount == Integer.MAX_VALUE) minCmdCount = -1;
        return minCmdCount;
    }
    
    public int calcCmdCount(int startIdx, int endIdx){
        // startIdx ~ endIdx 의 구간 = A구간
        
        int sum = 0;
        
        // A구간이 Q1에 전부 속함
        if(endIdx < N){
            if(debugMode){
                System.out.println("여기에 들어감");
            }
            
            // System.out.println("Case1");
            // sum += idxToCount(0,endIdx);
            // if(debugMode){
            //     System.out.println(sum);
            // }
            // sum += N;
            // if(debugMode){
            //     System.out.println(sum);
            // }
            // sum += idxToCount(0,startIdx-1);
            // if(debugMode){
            //     System.out.println(sum);
            // }
            
            
            if(endIdx == N-1){
                sum = startIdx;
            }
            else{
                sum = endIdx + startIdx - 1 + N;
            }
        }
        // A구간이 Q2에 전부 속함
        else if(startIdx >= N) {
            // // System.out.println("Case2");
            // sum += idxToCount(N,endIdx);
            // sum += N;
            // sum += idxToCount(N,startIdx-1);
            if(endIdx == fullSize-1){
                sum = startIdx - N;
            }
            else{
                sum = startIdx + endIdx - N + 1;
            }
        }
        // A구간이 두 큐에 걸쳐있음
        else{
            // System.out.println("Case3");
            sum += idxToCount(0,startIdx-1);
            sum += idxToCount(N,endIdx);
            // sum = startIdx + endIdx - N + 1;
        }
        
        // System.out.println(sum +"입니다.");
        
        
        if(debugMode){
            System.out.println("cmd 횟수 : " + sum);
        }
        
        return sum;
            
    }
    
    public int idxToCount(int a,int b){
        if(b < a)return 0;
        return b-a+1;
    }
    
    public void BS(int fixIdx){
        
        int start = fixIdx;
        int end = fullSize-1;
        
        while(start <= end){
            int mid = (start+end) / 2;
            
            
           
            
            int result = tooBig(fixIdx,mid);
            
            if(debugMode){
                 System.out.println("mid 값 : " + mid + " reuslt 값 : " + result);
            }
            
            if(result == 1){
                end = mid - 1;
            }
            else if(result == -1){
                start = mid + 1;
            }
            else{
                // System.out.println("합이 같은 구간을 찾았습니다 : " + fixIdx + " , " + mid);
                
                
                minCmdCount = Math.min(minCmdCount, calcCmdCount(fixIdx, mid));
                
                // System.out.println("--");
                return;
            }
        }
    }
    
    // 범위가 너무 크면 1 -> BS가 왼쪽으로 이동하도록.
    // 범위가 너무 작으면 -1 -> BS가 오른쪽으로 이동하도록
    // 범위를 찾으면 0 -> 찾음!
    public int tooBig(int aIdx, int bIdx){
        
        long ARange = getRangeSum(aIdx,bIdx);
        long BRange = everyItemSum - ARange;
        
        if(ARange > BRange) return 1;
        if(ARange < BRange) return -1;
        if(ARange == BRange) return 0;
        
        for(int i=0;i<2000000;i++){
            System.out.println("ERROR");    
        }
        
        return -2;
    }
    
    
    public long getRangeSum(int start,int end){
        if(start == 0) return hap[end];
        return hap[end] - hap[start-1];
    }
    
    public void init(int[] a,int[] b){
        
        
        N = a.length;
        fullSize = 2*N;
        arr = new long[N*2];
        hap = new long[N*2];
        
        for(int i=0;i<N;i++){
            arr[i] = a[i];
            arr[i+N] = b[i];
        }
        
        for(int i=0;i<fullSize;i++){
            if(i==0){
                hap[i] = arr[i];
            }
            else{
                hap[i] = hap[i-1] + arr[i];
            }
            everyItemSum += arr[i];
        }
    }
}