import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        //String s[] = br.readLine().split(" ");
        int pre, count=N;
        int differ, result;

        for(int i=1;i<=N;i++) {
            result = i;
            pre = result % 10;
            result = result/10;
            differ = pre - (result % 10);
            while (result != 0) {
                if ((pre - differ) != result % 10) {
                    count--;
                    break;
                }
                pre = result % 10;
                result = result / 10;
            }
        }

        System.out.print(count);
    }
}