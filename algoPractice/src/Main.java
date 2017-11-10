import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static int[] alpha = new int[200];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int group_num=T;

        for(int i=0;i<T;i++) {
            String s[] = br.readLine().split("");

            for(int j=97;j<=122;j++) {
                alpha[j] = -1;
            }

            for(int j=1;j<s.length;j++) {
                if(!s[j-1].equals(s[j])) {
                    if(alpha[(int) s[j].charAt(0)] != -1) {
                        group_num--;
                        break;
                    }
                    alpha[(int) s[j-1].charAt(0)] = 0;
                }
            }
        }
        System.out.print(group_num);;
    }
}