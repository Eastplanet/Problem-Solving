package ps;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_16120 {

	public static void main(String[] args) throws Exception  {
		
		//System.setIn(new FileInputStream("1204_input.txt"));
		
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
       
        String word = in.readLine();
        
        Stack<Character> S = new Stack<>();
        
        for(int i=word.length()-1;i>=0;i--) {
        	S.push(word.charAt(i));
        }
        
        
        Stack<Character> buff = new Stack<Character>();
        boolean flag = false;
        
        while(true) {
        	
        	if(S.size()!=0) {
    			buff.push(S.pop());
    		}
        	else {
        		if(buff.size()==1) {
        			if(buff.pop()=='P') {
        				flag = true;
        				break;
        			}
        			else {
        				flag = false;
        				break;
        			}
        		}
        		else {
        			flag = false;
        			break;
        		}
        	}
        	
        	if(buff.size()<4)continue;
        	
        	
        	char[] arr = new char[4];
        	
        	for(int i=3;i>=0;i--) {
        		arr[i] = buff.pop();
        	}
        	
        	if(arr[0] == 'P' && arr[1] == 'P' && arr[2] == 'A' && arr[3] == 'P') {
        		S.push('P');
        	}
        	else {
        		for(int i=0;i<4;i++) {
        			buff.push(arr[i]);
        		}
        	}
        	
        	
        	
        	
        	
        	
        }
        
        if(flag == true)System.out.println("PPAP");
        else System.out.println("NP");
        
        
        
	}
}
