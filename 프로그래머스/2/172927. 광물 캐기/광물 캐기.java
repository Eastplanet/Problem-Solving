import java.lang.*;
import java.util.*;

class Solution {
    
    static class Block{
        int diaCnt,ironCnt,stoneCnt;
        Block(int diaCnt, int ironCnt, int stoneCnt){
            this.diaCnt = diaCnt;
            this.ironCnt = ironCnt;
            this.stoneCnt = stoneCnt;
        }
    }
    
    public int solution(int[] picks, String[] minerals) {
        
        Block[] blocks = new Block[minerals.length/5+1];
        for(int i=0;i<blocks.length;i++){
            blocks[i] = new Block(0,0,0);
        }
        
        
        int pickCount = picks[0] + picks[1] + picks[2];
        
        for(int i=0;i<minerals.length;i++){
            
            if(i == pickCount*5){
                break;
            }
            
            //0~4 -> 0 , 5~9 -> 1, 
            int idx = i/5;
            
            if(minerals[i].equals("diamond")){
                blocks[idx].diaCnt++;
            }
            else if(minerals[i].equals("iron")){
                blocks[idx].ironCnt++;
            }
            else{
                blocks[idx].stoneCnt++;
            }
        }
        
        Arrays.sort(blocks,(b1,b2)->{
            if(b1.diaCnt == b2.diaCnt){
                if(b1.ironCnt == b2.ironCnt){
                    return b2.stoneCnt - b1.stoneCnt;
                }
                else{
                    return b2.ironCnt - b1.ironCnt;
                }
            }
            else{
                return b2.diaCnt - b1.diaCnt;
            }
        });
        
        
        int minningCnt = 0;
        int nowblock = 0;
        int HP = 0;
        
        while(true){
            if((picks[0] == 0 && picks[1] == 0 && picks[2] == 0) || (minningCnt == minerals.length)){
                break;
            }
            
            if(picks[0] != 0){
                picks[0]--;
                HP += blocks[nowblock].diaCnt;
                HP += blocks[nowblock].ironCnt;
                HP += blocks[nowblock].stoneCnt;
            }
            else if(picks[1] != 0){
                picks[1]--;
                HP += blocks[nowblock].diaCnt * 5;
                HP += blocks[nowblock].ironCnt;
                HP += blocks[nowblock].stoneCnt;
            }
            else if(picks[2] != 0){
                picks[2]--;
                HP += blocks[nowblock].diaCnt * 25;
                HP += blocks[nowblock].ironCnt * 5; 
                HP += blocks[nowblock].stoneCnt;
            }
            
            minningCnt += blocks[nowblock].diaCnt;
            minningCnt += blocks[nowblock].ironCnt;
            minningCnt += blocks[nowblock].stoneCnt;
            nowblock++;
        }
        
        
        int answer = HP;
        return answer;
    }
}