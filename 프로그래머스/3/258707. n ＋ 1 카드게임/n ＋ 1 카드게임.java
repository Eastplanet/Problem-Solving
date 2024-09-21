import java.lang.*;
import java.util.*;

class Solution {
    
    int[][] pair;
    int N;
    int target;
    int[] numToIdx;
    int[] visited;
    
    public int solution(int coin, int[] cards) {
        
        init(cards);
    
        int canRound = 1;
        int nowCoin = coin;
        
        boolean twoCoinOk = false;
        
        int maxRound = (N-N/3)/2 + 1;
        System.out.println(maxRound);
        
        while(true){
            
              // System.out.println("포인트 1");
            
            // System.out.println("남은 코인" + nowCoin + " 가능 라운드 : " + canRound);
            // for(int i=0;i<N/2;i++){
            //     System.out.println(i+ "번 방문여부 "+ visited[i] + "  라운드:  " +pair[i][0] + " 코인 : " + pair[i][1]);
            // }
            
            boolean isChanged = false;
            
            for(int i=0;i<N/2;i++){
                
                 // System.out.println("포인트 2");
                
                int[] pairItem = pair[i];
                
                if(visited[i] == 1){
                    continue;
                }
                
                 // System.out.println("포인트 3");
                // System.out.println(pairItem[0] <= canRound && pairItem[1] == 2 && twoCoinOk == true && nowCoin >= 2);
                
                //바로 갈 수 있느 애인경우
                if(pairItem[1] == 0){
                    
                    // System.out.println("0원짜리를 샀음");
                    visited[i] = 1;
                    
                    canRound++;
                    
                    isChanged = true;
                    twoCoinOk = false;
                }
                else if(pairItem[0] <= canRound && pairItem[1] == 1 && nowCoin >= 1){
                    // System.out.println("1원짜리를 샀음");
                    visited[i] = 1;
                    
                    nowCoin--;
                    canRound++;
                    
                    isChanged = true;
                    twoCoinOk = false;
                }
                
                // 가성비 있느 1원을 한바퀴돌고 없으면 더블체크릃나다 이때는 2원짜리라도 한다.
                else if(pairItem[0] <= canRound && pairItem[1] == 2 && twoCoinOk == true && nowCoin >= 2){
                    // System.out.println("2원짜리를 샀음");
                    visited[i] = 1;
                    
                    nowCoin -= 2;
                    canRound++;
                    
                    isChanged = true;
                    twoCoinOk = false;
                }
            }
            
            if(isChanged == false){
                
                if(twoCoinOk == false){
                    twoCoinOk = true;
                }
                else{
                    // System.out.println("더는 못삼");
                    // 진짜 더 못삼
                    break;
                }
            }
        }
        
        if(canRound > maxRound)canRound = maxRound;
        
        return canRound;
    }
    
    public void init(int[] cards){
        
        N = cards.length;
        target = N+1;
        pair = new int[N][2];
        numToIdx = new int[N+2];
        visited = new int[(N/2)+1];
        
        for(int i=0;i<N;i++){
            numToIdx[cards[i]] = i;
        }
        
        int pairIdx = 0;
        
        for(int i=1;i<= N/2;i++){
            
            int first = i;
            int second = target - first;
            
            int firstIdx = numToIdx[first];
            int secondIdx = numToIdx[second];
            
            if(firstIdx < N/3 && secondIdx < N/3){
                // System.out.println("0 초기화");
                pair[pairIdx][0] = 1;
                pair[pairIdx++][1] = 0;
            }
            else if(firstIdx < N/3){
                // System.out.println("1 초기화");
                int round = secondIdx - N/3;
                round = round/2;
                round++;
                
                pair[pairIdx][0] = round;
                pair[pairIdx++][1] = 1;
            }
            else if(secondIdx < N/3){
                // System.out.println("1 초기화");
                int round = firstIdx - N/3;
                round = round/2;
                round++;
                
                pair[pairIdx][0] = round;
                pair[pairIdx++][1] = 1;
            }
            else{
                // System.out.println("2 초기화");
                int firstRound = firstIdx - N/3;
                firstRound = firstRound/2;
                firstRound++;
                
                int secondRound = secondIdx - N/3;
                secondRound = secondRound/2;
                secondRound++;
                
                int high = Math.max(firstRound, secondRound);
                pair[pairIdx][0] = high;
                pair[pairIdx++][1] = 2;
            }
        }
        
    }
}