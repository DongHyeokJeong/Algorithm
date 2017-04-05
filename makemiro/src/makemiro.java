import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class makemiro {
    static int N;
    static int[][] map = new int[51][51];
    static int[][] dp = new int[51][51];
    static int[][] direction = {{-1,0}, {0,1}, {1,0}, {0,-1}};

    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        for (int i = 1; i <= N; i++) {
            String s[] = br.readLine().split("");
            for (int j = 1; j <= N; j++) {
                map[i][j] = Integer.parseInt(s[j-1]);
            }
        }

        for(int i=1; i<=N; i++) {
            for(int j=1; j<=N; j++) {
                dp[i][j] = -1;
            }
        }

        System.out.print(bfs());
    }

    public static int bfs(){
        int[][] q = new int[100000][2]; // 0: y좌표, 1: x좌표
        int f=0;
        int r=0;
        int y=1,x=1;
        int dy, dx;

        q[r][0] = y;
        q[r][1] = x;
        r++;
        dp[1][1] = 0;

        while (f != r) {
            y = q[f][0];
            x = q[f][1];
            f++;

            for(int i=0; i<4; i++) {
                dy = y + direction[i][0];
                dx = x + direction[i][1];

                if(dy<1 || dy>N || dx<1 || dx>N) continue;
                if(dp[dy][dx] != -1 && dp[dy][dx] <= dp[y][x]) continue;

                if(map[dy][dx] == 0) {
                    dp[dy][dx] = dp[y][x] + 1;
                }
                else {
                    dp[dy][dx] = dp[y][x];
                }

                q[r][0] = dy;
                q[r][1] = dx;
                r++;
            }
        }

        return dp[N][N];
    }
}
