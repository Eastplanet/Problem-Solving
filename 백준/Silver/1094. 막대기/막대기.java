import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    

    public static void main(String[] args) throws Exception {
        int num = Integer.parseInt(in.readLine());
        String str = Integer.toBinaryString(num);
        int cnt = 0;
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)=='1'){
                cnt++;
            }
        }
        System.out.println(cnt);
    }


}