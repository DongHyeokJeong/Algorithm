import java.util.Scanner;

public class make1 {
    static int[] dp = new int[1000001];

    public static void main(String [] args) {
        int p;

        Scanner scan = new Scanner(System.in);
        p = scan.nextInt();

        dp[1]=0;

        for(int i=2;i<=p;i++) {
            dp[i] = dp[i-1]+1;
            if((i%2) == 0) {
                dp[i] = min(dp[i], dp[i/2]+1);
            }
            if((i%3) == 0) {
                dp[i] = min(dp[i], dp[i/3]+1);
            }
        }

        System.out.print(dp[p]);
    }

    public static int min(int a, int b){
        return a > b ? b : a;
    }
}
