import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class stair {
    static int N;
    static int[] stair = new int[301];
    static int[][] dp = new int[301][3];

    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        for(int i=1; i<=N; i++) {
            stair[i] = Integer.parseInt(br.readLine());
        }

        dp[1][1] = dp[1][2] = stair[1];
        dp[0][1] = dp[0][0] = 0;

        System.out.print(dp());
    }

    public static int dp() {
        for(int i=2;i<=N;i++) {
            dp[i][1] += max(dp[i-2][1]+stair[i],dp[i-2][2]+stair[i]);
            dp[i][2] += dp[i-1][1]+stair[i];
        }
        return max(dp[N][1],dp[N][2]);
    }

    public static int max(int a, int b) {
        return a>b?a:b;
    }
}