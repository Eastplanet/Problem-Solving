class Solution {
    
    public int peopleCnt;
    public boolean[] denyList;
    
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        peopleCnt = schedules.length;
        denyList = new boolean[peopleCnt];
        
        startday--;
        
        // 출근 시간에 10을 더한다.
        for(int i=0;i<peopleCnt;i++){
            schedules[i] = addTime(schedules[i]);
        }
        
        // timelog에서 지각한경우 deny를 갱신한다
        for(int i=0;i<peopleCnt;i++){
            
            for(int j=0;j<7;j++){
                int today = (startday + j)%7;
                
                if(today == 5 || today == 6){
                    continue;
                }
                
                if(schedules[i] < timelogs[i][j]){
                    denyList[i] = true;
                }
            }
        }
        
        int answer = 0;
        
        for(int i=0;i<peopleCnt;i++){
            if(denyList[i] == false){
                answer++;
            }
        }
        
        return answer;
    }
    
    public int addTime(int time){
        
        time = time + 10;
        // 분이 60분 넘은경우
        if(time % 100 >= 60){
            time -= 60;
            time += 100;
        }
        
        return time;
    }
}