import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    

    public static void main(String[] args) throws Exception {
        int d1 = Integer.parseInt(in.readLine());
        int d2 = Integer.parseInt(in.readLine());

        System.out.println((double)d1*2+3.141592*d2*2);
    }


}