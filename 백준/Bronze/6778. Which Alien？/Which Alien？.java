import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    

    public static void main(String[] args) throws Exception {
        int antenna = Integer.parseInt(in.readLine());
        int eye = Integer.parseInt(in.readLine());

        if(antenna >= 3 && eye <= 4){
            System.out.println("TroyMartian");
        }
        if(antenna <= 6 && eye >= 2){
            System.out.println("VladSaturnian");
        }
        if(antenna <= 2 && eye <= 3){
            System.out.println("GraemeMercurian");
        }
    }


}