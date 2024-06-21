import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws Exception{

        String tmp = in.readLine();
        if(tmp.equals("SONGDO")) System.out.println("HIGHSCHOOL");
        else if(tmp.equals("CODE")) System.out.println("MASTER");
        else if(tmp.equals("2023")) System.out.println("0611");
        else System.out.println("CONTEST");

    }





}