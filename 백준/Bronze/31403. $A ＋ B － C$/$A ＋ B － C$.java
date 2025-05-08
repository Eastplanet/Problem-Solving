
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;

    public static void main(String[] args) throws Exception {

        String A = in.readLine();
        String B = in.readLine();
        String C = in.readLine();

        System.out.println(Integer.parseInt(A)+Integer.parseInt(B)-Integer.parseInt(C));
        System.out.println(Integer.parseInt(A+B)-Integer.parseInt(C));

    }




}