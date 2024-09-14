import java.lang.*;
import java.util.*;

class Solution {
    
    int robotCnt;
    int[][][] pathRecord;
    
    
    public int solution(int[][] points, int[][] routes) {
        
        pathRecord = new int[101][101][20100];
        robotCnt = routes.length;
        
        for(int i=0;i<robotCnt;i++){
            markingRobotPath(i, points, routes);
        }
        
        int result = 0;
        
        for(int i=1;i<=100;i++){
            for(int j=1;j<=100;j++){
                for(int t=0;t<=20000;t++){
                    if(pathRecord[i][j][t] > 1){
                        result++;
                    }
                }
            }
        }
        
        return result;
    }
    
    public void markingRobotPath(int robotIdx, int[][] points, int[][] routes){
        
        int[] path = routes[robotIdx];
        int pathSize = path.length;
        
        int startTime = 0;
        
        // 첫 위치는 손으로 찍어줘야함 @TODO
        int nowY = points[path[0]-1][0];
        int nowX = points[path[0]-1][1];
        pathRecord[nowY][nowX][startTime]++;
        startTime++;
        
        
        for(int i=0; i< pathSize - 1 ; i++){
            startTime = markNowToNext(path[i],path[i+1], points, startTime);
        }
        
        
    }
    
    public int markNowToNext(int now, int next, int[][] points, int startTime){
        
        int nowY = points[now-1][0];
        int nowX = points[now-1][1];
        int nextY = points[next-1][0];
        int nextX = points[next-1][1];
        

        int dy = nowY - nextY;
        while(dy != 0){
            // 내려가야 하는 경우
            if(dy < 0){
                nowY++;
                pathRecord[nowY][nowX][startTime]++;
                startTime++;
            }
            // 올라가야 하는 경우
            else if(dy > 0){
                nowY--;
                pathRecord[nowY][nowX][startTime]++;
                startTime++;
            }
            
            dy = nowY - nextY;
        }
        
        
        int dx = nowX - nextX;
        while(dx != 0){
            // 내려가야 하는 경우
            if(dx < 0){
                nowX++;
                pathRecord[nowY][nowX][startTime]++;
                startTime++;
            }
            // 올라가야 하는 경우
            else if(dx > 0){
                nowX--;
                pathRecord[nowY][nowX][startTime]++;
                startTime++;
            }
            
            dx = nowX - nextX;
        }
        
        
        return startTime;
    }
    
}