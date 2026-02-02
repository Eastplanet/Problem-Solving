import java.util.*;
import java.lang.*;

class Solution {
    public String solution(int n, int t, int m, int p) {
        // testNumberToN();
        
        // 사람이 5명일 때, 총 길이가 15이면 딱 3번씩 말할 수 있다.
        // 사람이 m명일 때, 총 길이가 m*t이면 딱 t번 씩 말할 수 있다.
        StringBuilder sb = new StringBuilder();
        int number = 0;
        
        // 말해야하는 순서를 전부 구한다 123456789... 튜브가 t번 말할 수 있을만큼 충분히
        while(sb.toString().length() < m * t){
            // sb.append(numberToN(number, n));
            sb.append(Integer.toString(number,n).toUpperCase());
            number++;
        }
        
        // 인원수 * 말해야 하는 수 만큼 정확히 자른다.
        String sequence = sb.toString();
        // sequence = sequence.substring(0,m*t);
        
        // 튜브가 말하는 단어만 추출한다.
        sb = new StringBuilder();
        p--;
        for(int i=0;i<sequence.length();i++){
            if(i%m == p) sb.append(sequence.charAt(i));
            if(sb.toString().length() == t) break;
        }
        
        return sb.toString();
    }
    
    public String numberToN(int number, int n) {
        StringBuilder sb = new StringBuilder();
        
        while(true){
            
            int left = number % n;
            if(left >= 10){
                if(left == 10) sb.append('A');
                if(left == 11) sb.append('B');
                if(left == 12) sb.append('C');
                if(left == 13) sb.append('D');
                if(left == 14) sb.append('E');
                if(left == 15) sb.append('F');
            }
            else {
                sb.append(left);    
            }
            
            number /= n;
            if(number < n) {
                if(number != 0) sb.append(number);
                break;
            }
        }
        
        String reverse = sb.toString();
        sb = new StringBuilder();
        for(int i=reverse.length()-1;i>=0;i--){
            sb.append(reverse.charAt(i));
        }
        
        return sb.toString();
    }
    
    void testNumberToN() {
        
        int n = 2;
        for(int i=0;i<15;i++){
            System.out.println(n + "진법 , 숫자 " + i + " = " + numberToN(i,n));
        }
        
        n = 3;
        for(int i=0;i<15;i++){
            System.out.println(n + "진법 , 숫자 " + i + " = " + numberToN(i,n));
        }
        
        n = 16;
        for(int i=0;i<64;i++){
            System.out.println(n + "진법 , 숫자 " + i + " = " + numberToN(i,n));
        }
    }
}