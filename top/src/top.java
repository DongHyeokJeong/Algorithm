import java.util.Scanner;

public class top {
    public static int[] top;
    public static int[] dp;
    public static int N;

    public static void main(String [] args) {
        Scanner scan = new Scanner(System.in);

        N = scan.nextInt();
        top = new int[N+1];
        dp = new int[N+1];  // i번째 보다 높은 타워의 번호

        for(int i=1;i<=N;i++) {
            top[i] = scan.nextInt();
            dp[i] = -1;
        }
        top[0] = 1000000001;
        dp[0] = 0;
        dp[1] = 0;

        for(int i=2; i<=N;i++) {
            int t=i-1;

            if(top[i-1] > top[i]) {
                dp[i] = i-1;
            }
            else {
                while(dp[i] == -1) {
                    if(top[dp[t]] > top[i]) {
                        dp[i] = dp[t];
                    }
                    else {
                        t = dp[t];
                    }
                }
            }
        }

        for(int i=1;i<=N;i++) {
            System.out.print(dp[i] + " ");
        }
    }
}
