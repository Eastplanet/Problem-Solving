import java.lang.*;
import java.util.*;



class Solution {
    
    public int H,W;
    public Queue<Pos> q;
    public char[][] arr;
    public int[][] visited;
    public int[] dx = {0, 0, 1, -1};
    public int[] dy = {1, -1, 0, 0};
    
    public int solution(String[] board) {
        init(board);
        return BFS();
    }
    
    public int BFS() {
        
        while(!q.isEmpty()){
            Pos curr = q.poll();
            
            if(arr[curr.y][curr.x] == 'G'){
                return curr.cnt;
            }
            
            for(int i=0;i<4;i++){
                int[] next = go(curr.x,curr.y,i);
                
                if(visited[next[1]][next[0]] == 1){
                    continue;
                }
                
                visited[next[1]][next[0]] = 1;
                q.add(new Pos(next[0],next[1],curr.cnt+1));
            }
        }
        
        return -1;
    }
    
    public int[] go(int x,int y,int delta){
        
        int prevx = x;
        int prevy = y;
        int gox = x + dx[delta];
        int goy = y + dy[delta];
        
        while(true){
            //범위 초과시 break
            if(gox < 0 || gox>= W || goy < 0 || goy >= H || arr[goy][gox] == 'D'){
                break;
            }
            
            prevx = gox;
            prevy = goy;
            gox += dx[delta];
            goy += dy[delta];
        }
        
        return new int[] {prevx,prevy};
    }
    
    public void init(String[] board){
        H = board.length;
        W = board[0].length();
        arr = new char[H][W];
        visited = new int[H][W];
        q = new ArrayDeque<>();
        
        for(int i=0;i<H;i++){
            
            for(int j=0;j<W;j++){
                
                arr[i][j] = board[i].charAt(j);
                if(arr[i][j]=='R'){
                    q.add(new Pos(j,i,0));
                    arr[i][j] = '.';
                }
            }
        }
    }
    
}

class Pos {
    int x,y,cnt;
    public Pos(int x,int y,int cnt){
        this.x = x;
        this.y = y ;
        this.cnt = cnt;
    }
}














