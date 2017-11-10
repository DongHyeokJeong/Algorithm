import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class star {
    public static String[] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        //String s[] = br.readLine().split(" ");
        int height = (int) (Math.log(N/3) / Math.log(2)) + 1;
        result = new String[N+1];
        int incr = 3;

        result[1] = "  *  ";
        result[2] = " * * ";
        result[3] = "*****";

        for(int i=1; i<height; i++) {
            for(int j=1;j<=incr;j++) {
                result[incr+j] = result[j] + " " + result[j];
                for(int k=1; k<=incr/3;k++) {
                    result[j] = "   " + result[j] + "   ";
                }
            }
            incr *= 2;
        }

        for(int i=1;i<=incr;i++) {
            System.out.println(result[i]);
        }
    }
}
