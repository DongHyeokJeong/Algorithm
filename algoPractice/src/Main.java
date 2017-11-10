import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //int N = Integer.parseInt(br.readLine());

        String s1 = br.readLine().trim();
        String s2[] = s1.split(" ");

        if(s2[0].isEmpty()) {
            System.out.print(s2.length-1);
        } else {
            System.out.print(s2.length);
        }
    }
}