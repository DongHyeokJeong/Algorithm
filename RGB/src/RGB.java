import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RGB {
    static int[] dp = new int[1001];
    static int[][] cost;
    static int N;

    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        int pre;

        cost = new int[N+1][4];
        for (int i = 1; i <= N; i++) {
            String s[] = br.readLine().split(" ");
            for (int j = 1; j <= 3; j++) {
                cost[i][j] = Integer.parseInt(s[j-1]);
            }
        }

        System.out.print(dp());
    }

    public static int dp() {
        for(int i=2;i<=N;i++) {
            cost[i][1] += min(cost[i-1][2],cost[i-1][3]);
            cost[i][2] += min(cost[i-1][1],cost[i-1][3]);
            cost[i][3] += min(cost[i-1][1],cost[i-1][2]);
        }

        return min(min(cost[N][1],cost[N][2]),cost[N][3]);
    }

    public static int min(int a, int b){
        return a>b?b:a;
    }
}