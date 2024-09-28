class Solution {
    
    // 각 이모티콘이 얼마나 할인할 지 여기다가 저장
    int[] discountSetting;
    int maxRegister;
    int maxPrice;
    
    int emoteCnt;
    int userCnt;
    
    int[][] user;
    int[] emote;
    
    public int[] solution(int[][] users, int[] emoticons) {
        int[] answer = {};
        
        emoteCnt = emoticons.length;
        userCnt = users.length;
        discountSetting = new int[emoteCnt];
        user = users;
        emote = emoticons;
        
        makeDisSetting(0);
        
        answer = new int[]{maxRegister, maxPrice};
        return answer;
    }
    
    // discountSetting 조합으로 뽑는 함수
    public void makeDisSetting(int idx){
        
        if(idx == emoteCnt){
            int[] result = calc();
            update(result[0],result[1]);
            return;
        }
        
        for(int i=1;i<=4;i++){
            discountSetting[idx] = i*10;
            makeDisSetting(idx+1);
        }
        
    }
    
    // discountSetting을 이용해 가입자, 판매액 계산하는 함수
    public int[] calc(){
        
        int priceSum = 0;
        int registerSum = 0;
        
        for(int i=0;i<userCnt;i++){
            
            int personPrice = 0;
            
            for(int j=0;j<emoteCnt;j++){
                // 할인이 크면
                if(user[i][0] <= discountSetting[j]){
                    //구매한다.
                    int val = (int)(emote[j]/100*((double)(100-discountSetting[j])));
                    personPrice += val;
                    // System.out.println("할인 비율이 "+discountSetting[j]+"이고 가격은"+emote[j]+"여서 총 가격은"+val);
                }
            }
            
            // 돈이 일정 이상이면 그냥 가입
            if(personPrice >= user[i][1]){
                registerSum++;
            }
            else{
                priceSum += personPrice;
            }
        }
        
        return new int[]{registerSum,priceSum};
    }
    
    
    //최대값 갱신 함수
    public void update(int register, int price){
        
        if(maxRegister < register){
            maxRegister = register;
            maxPrice = price;
        }
        else if(maxRegister == register){
            maxPrice = Math.max(maxPrice, price);
        }
    }
}