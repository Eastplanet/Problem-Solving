
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        int A = Integer.parseInt(in.readLine());
        int B = Integer.parseInt(in.readLine());

        int C = (A+B)%12;
        if(C == 0){
            System.out.println(12);
        }
        else{
            System.out.println(C);
        }
    }
}