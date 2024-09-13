import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;


    public static void main(String[] args) throws Exception {

        int A = Integer.parseInt(in.readLine());
        int B = Integer.parseInt(in.readLine());

        System.out.println("All positions change in year "+A);

        while(true){
            if(A + 60 <= B){
                A += 60;
                System.out.println("All positions change in year "+A);
            }
            else{
                break;
            }
        }
    }



}