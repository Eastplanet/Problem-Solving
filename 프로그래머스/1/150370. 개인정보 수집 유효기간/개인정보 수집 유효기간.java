import java.lang.*;
import java.util.*;

class Solution {
    
    
    int[] arr = new int[50];
    
    
    public int[] solution(String today, String[] terms, String[] privacies) {
        int[] answer = {};
        
        for(int i=0;i<terms.length;i++){
            String tmp = terms[i];
            int val = 0;
            if(tmp.length() == 3){
                val = (tmp.charAt(2)-'0');
            }
            else if(tmp.length() == 4){
                val = (tmp.charAt(2)-'0')*10;
                val += (tmp.charAt(3)-'0');
            }
            else if(tmp.length() == 5){
                val = (tmp.charAt(2)-'0')*100;
                val += (tmp.charAt(3)-'0')*10;
                val += (tmp.charAt(4)-'0');
            }
            
            // System.out.print(val+ "개월이 일수로 변환하면");
            val = val*(28)-1;
            System.out.println(val);
            // System.out.println(tmp.charAt(0)+"은"+(tmp.charAt(0)-'A')+"인덱스에 저장");
            arr[tmp.charAt(0)-'A'] = val;
        }
        
        List<Integer> result = new ArrayList<>();
        
        
        for(int i=0;i<privacies.length;i++){
            if(checkOverDate(today,privacies[i])){
                result.add(i+1);
            }
        }
        
        answer = new int[result.size()];
        for(int i=0;i<result.size();i++){
            answer[i] = result.get(i);
        }
        
        
        return answer;
    }
    
    
    public boolean checkOverDate(String today, String privacies){
        
        String tmp = privacies.substring(0,10);
        int val = dateToInt(tmp);
        // System.out.println("개인정보 입력 날짜"+val);
        // System.out.println("개인정보 만료 일수"+arr[privacies.charAt(11)-'A']);
        
        
        // System.out.print(dateToInt(today) + " <오늘 날짜 ---- 파기해야하는 날짜> ");
        System.out.println(val+arr[privacies.charAt(11)-'A']);
        
        if(dateToInt(today) > val+arr[privacies.charAt(11)-'A']){
            // System.out.println("파기해야해!");
            return true;
        }
        else{
            // System.out.println("실패");
            return false;
        }
        
    }
    
    
    public int dateToInt(String date){
        
        int year = (date.charAt(0)-'0')*1000;
        year += (date.charAt(1)-'0')*100;
        year += (date.charAt(2)-'0')*10;
        year += (date.charAt(3)-'0');
        
        
        int month = (date.charAt(5)-'0')*10;
        month += (date.charAt(6)-'0');
        
        
        int day = (date.charAt(8)-'0')*10;
        day += (date.charAt(9)-'0');
        
        
        int sum = 0;
        
        sum += day-1;
        sum += (month-1)*28;
        sum += (year-2000)*28*12 + 1;
        
        
        return sum;
    }
        
        
        
}