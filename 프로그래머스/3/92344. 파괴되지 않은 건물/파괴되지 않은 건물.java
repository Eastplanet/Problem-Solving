class Solution {
    
    public static final int ATTACK = 1;
    public static final int REPAIR = 2;
    
    public int solution(int[][] board, int[][] skill) {
        
        int N = board.length;
        int M = board[0].length;
        
        int[][] point = new int[N+1][M+1];
        
        for(int i=0;i<skill.length;i++){
            int type = skill[i][0];
            int r1 = skill[i][1];
            int c1 = skill[i][2];
            int r2 = skill[i][3];
            int c2 = skill[i][4];
            int degree = skill[i][5];
            
            if(type == ATTACK){
                degree *= -1;
                
                point[r1][c1] += degree;
                point[r1][c2+1] += -1*degree;
                point[r2+1][c1] += -1*degree;
                point[r2+1][c2+1] += degree;
            }
            else if(type == REPAIR){
                point[r1][c1] += degree;
                point[r1][c2+1] += -1*degree;
                point[r2+1][c1] += -1*degree;
                point[r2+1][c2+1] += degree;
            }
        }
        
        for(int i=0;i<N;i++){
            for(int j=1;j<M;j++)point[i][j] += point[i][j-1];
        }
        
        for(int j=0;j<M;j++){
            for(int i=1;i<N;i++)point[i][j] += point[i-1][j];
        }
        
        
        
        int answer = 0;
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(point[i][j] + board[i][j] > 0)answer++;
            }
        }
        return answer;
    }
}