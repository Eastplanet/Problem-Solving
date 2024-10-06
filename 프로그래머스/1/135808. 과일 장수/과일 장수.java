import java.lang.*;
import java.util.*;

class Solution {
    public int solution(int k, int m, int[] score) {
        
        int[] arr = new int[10];
        for(int i=0;i<score.length;i++){
            arr[score[i]]++;
        }
        
        int sum = 0;
        
        
        Arrays.sort(score);
        
        int idx = score.length-1;
        while(idx > 0){
            if(idx < m-1){
                break;
            }
            sum += m*score[idx-m+1];
            idx -= m;
            
        }
        
            
        
        return sum;
    }
}