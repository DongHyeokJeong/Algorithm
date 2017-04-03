import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created by JDH on 2017-04-03.
 */
public class fibonacci {
    static int[] problem;
    static int[] cache = new int[41];
    static int conut_0=0;
    static int conut_1=0;

    public static void main (String [] args) throws Exception {
        int T;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        problem = new int[T];

        Arrays.fill(cache,-1);
        cache[0]=0;
        cache[1]=1;

        for (int i = 0; i < T; i++) {
            problem[i] = Integer.parseInt(br.readLine());
        }

        for(int i=0;i<T;i++) {
            fibonacci(problem[i]);
            System.out.println(conut_0 + " " + conut_1);
            conut_0=0;
            conut_1=0;
        }
    }

    public static int fibonacci(int n) {
        if (n==0) {
            conut_0++;
            return cache[0];
        } else if (n==1) {
            conut_1++;
            return cache[1];
        } else {
            if(cache[n] != -1) {
                return cache[n];
            }
            else {
                cache[n] = fibonacci(n-1) + fibonacci(n-2);
                return cache[n];
            }
        }
    }
}
