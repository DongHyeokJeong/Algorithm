import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class margarita {
    public static int N, V, D, cnt;
    public static int[] MA;
    public static int[] check;

    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        for(int k=0;k<N;k++) {
            String s[] = br.readLine().split(" ");
            V = Integer.parseInt(s[0]);
            D = Integer.parseInt(s[1]);

            cnt = 0;

            MA = new int[V+1];
            check = new int[V+1];

            s = br.readLine().split(" ");
            for(int i=0;i<V;i++) {
                MA[i+1] = Integer.parseInt(s[i]);
                check[i+1] = -1;
            }

            Arrays.sort(MA);
            margarita(V);

            System.out.println(k+1 + " " + cnt);
        }
    }

    public static void margarita(int toPick) {
        if(toPick < 0) {
            return;
        }

        if(D < 0) {
            return;
        }

        if(check()) {
            cnt++;
            return;
        }

        for(int i=toPick; i>0; i--) {
            D = D - MA[i];
            check[i] = 0;
            margarita(i-1);
            D = D + MA[i];
            check[i] = -1;
        }
    }

    public static boolean check() {
        for(int i=1;i<=V;i++) {
            if(check[i] == -1){
                if(MA[i] <= D) {
                    return false;
                }
            }
        }
        return true;
    }
}