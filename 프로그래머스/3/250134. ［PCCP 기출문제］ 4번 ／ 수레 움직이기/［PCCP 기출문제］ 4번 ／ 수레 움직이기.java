import java.util.*;
import java.lang.*;

class Solution {
    
    int N, M;
    int[][] mazeCp;
    
    int[] dy = {0,0,1,-1};
    int[] dx = {1,-1,0,0};
    
    int minCnt = Integer.MAX_VALUE;
    
    public int solution(int[][] maze) {
        
        mazeCp = maze;
        
        N = maze.length;
        M = maze[0].length;
        
        int[] red = new int[2];
        int[] blue = new int[2];
        
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(maze[i][j] == 1){
                    red[0] = i;
                    red[1] = j;
                }
                else if(maze[i][j] == 2){
                    blue[0] = i;
                    blue[1] = j;
                }
            }
        }
        
        int[][] RVisit = new int[4][4];
        int[][] BVisit = new int[4][4];
        
        RVisit[red[0]][red[1]] = 1;
        BVisit[blue[0]][blue[1]]= 1;
        
        DFS(red,blue ,RVisit, BVisit, 2);
        
        if(minCnt == Integer.MAX_VALUE){
            return 0;
        }
        
        return minCnt-2;
    }
    
    public void DFS(int[] red, int[] blue, int[][] Rvisit, int[][] Bvisit, int cnt){
        
        // System.out.println("cnt is : "+ minCnt);
            
//             for(int i=0;i<N;i++){
//                 for(int j=0;j<M;j++){
//                     System.out.print(Rvisit[i][j] +" ");
//                 }
//                 System.out.println();
//             }
            
//             System.out.println("-----------");

//             for(int i=0;i<N;i++){
//                 for(int j=0;j<M;j++){
//                     System.out.print(Bvisit[i][j] +" ");
//                 }
//                 System.out.println();
//             }

            // for(int i=0;i<N;i++){
            //     for(int j=0;j<M;j++){
            //         if(i == red[0] && j == red[1]){
            //             System.out.print("R");
            //         }
            //         else if(i == blue[0] && j == blue[1]){
            //             System.out.print("B");
            //         }
            //         else{
            //             System.out.print("@");
            //         }
            //     }
            //     System.out.println();
            // }
        
        
        List<int[]> rList = makePossibleGo(red, Rvisit);
        List<int[]> bList = makePossibleGo(blue, Bvisit);
        
        boolean redIsFin = false;
        
        if(mazeCp[red[0]][red[1]] == 3){
            redIsFin = true;
            rList = new ArrayList<>();
            rList.add(new int[]{red[0],red[1]});
        }
        
        
        boolean blueIsFin = false;
        
        if(mazeCp[blue[0]][blue[1]] == 4){
            blueIsFin = true;
            bList = new ArrayList<>();
            bList.add(new int[]{blue[0],blue[1]});
        }
        
        if(redIsFin && blueIsFin){
            minCnt = Math.min(minCnt, cnt);
            return;
        }
        
        
        List<int[]> combList = makeComb(rList, bList);
        
        for(int i=0;i<combList.size();i++){
            int[] comb = combList.get(i);
            
            int rY = comb[0];
            int rX = comb[1];
            int bY = comb[2];
            int bX = comb[3];
            
            // 똑같은 위치에 가는거 불가능
            if(rY == bY && rX == bX){
                continue;
            }
            
            // 서로 위치 교환하는 거 불가능
            if((rY == blue[0] && rX == blue[1] && bY == red[0] && bX == red[1])){
                continue;
            }
            
            Rvisit[rY][rX] = cnt;
            Bvisit[bY][bX] = cnt;
            
            
            
            DFS(new int[]{rY,rX},new int[]{bY,bX},Rvisit, Bvisit, cnt+1);
            
            Rvisit[rY][rX] = 0;
            Bvisit[bY][bX] = 0;
            
            
        }
        
    }
    
    public List<int[]> makePossibleGo(int[] pos, int[][] visit){
        
        List<int[]> list = new ArrayList<>();
        for(int i=0;i<4;i++){
            int goy = pos[0] + dy[i];
            int gox = pos[1] + dx[i];
            
            if(canGo(goy,gox,visit)){
                list.add(new int[]{goy,gox});
            }
        }
        
        return list;
    }
    
    public List<int[]> makeComb(List<int[]> rList, List<int[]> bList){
        
        List<int[]> combList = new ArrayList<>();
        for(int i=0;i<rList.size();i++){
            for(int j=0;j<bList.size();j++){
                int[] tmp = new int[4];
                tmp[0] = rList.get(i)[0];
                tmp[1] = rList.get(i)[1];
                tmp[2] = bList.get(j)[0];
                tmp[3] = bList.get(j)[1];
                combList.add(tmp);
            }
        }
        
        return combList;
    }
    
    
    public boolean canGo(int goy, int gox, int[][] visit){
        if(goy < 0 || goy >= N || gox < 0 || gox >= M)return false;
        if(mazeCp[goy][gox] == 5)return false;
        if(visit[goy][gox] != 0)return false;
        
        return true;
    }
}