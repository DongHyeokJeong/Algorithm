import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //int T = Integer.parseInt(br.readLine());
        String s = br.readLine();
        char[] c = new char[101];
        int count=0;

        for(int i=0;i<s.length();i++) {
            c[i] = s.charAt(i);
        }

        for (int i = 0; i<101; i++) {
            if (c[i] == '=' || c[i] == '-') c[i] = '0';
            if (c[i] == 'z' && c[i + 1] == '=' && c[i - 1] == 'd') c[i] = '0';
            if (c[i] == 'j' && (c[i - 1] == 'l' || c[i - 1] == 'n')) c[i] = '0';
        }

        for(int i=0;i<s.length();i++) {
            if(c[i] != '0') {
                count++;
            }
        }

        System.out.print(count);
    }
}