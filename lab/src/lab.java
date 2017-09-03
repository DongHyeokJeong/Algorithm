import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class lab {
    static int N, M, MAX;
    static int[][] map;
    static int[][] visited;
    static int[][] direction = {{0,1}, {1,0}, {0,-1}, {-1,0}};

    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s[] = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);

        map = new int[N + 1][M + 1];
        visited = new int[N + 1][M + 1];

        for (int i = 1; i <= N; i++) {
            s = br.readLine().split(" ");
            for (int j = 1; j <= M; j++) {
                map[i][j] = Integer.parseInt(s[j - 1]);
                visited[i][j] = -1;
            }
        }

        lab(3);
        System.out.print(MAX);
    }

    public static void lab(int n) {
        //기저사례
        if(n == 0) {
            int a = dfsAll();

            if(a > MAX) {
                MAX = a;
            }
            return;
        }

        for(int i=1; i<=N; i++) {
            for(int j=1; j<=M; j++) {
                if(map[i][j]==0) {
                    map[i][j]=1;
                        lab(n-1);
                    map[i][j]=0;
                }
            }
        }
    }

    public static int dfsAll() {
        int count=0;

        for(int i=1; i<=N; i++) {
            for(int j=1; j<=M; j++) {
                if(map[i][j] == 2 && visited[i][j] == -1) {
                    dfs(i,j);
                }
            }
        }

        for(int i=1; i<=N; i++) {
            for(int j=1; j<=M; j++) {
                if(visited[i][j]==-1 && map[i][j]==0) {
                    count++;
                }
            }
        }

        for(int i=1;i<=N;i++) {
            for(int j=1;j<=M;j++) {
                visited[i][j] = -1;
            }
        }

        return count;
    }

    public static void dfs(int here_y, int here_x) {
        visited[here_y][here_x] = 0;

        for(int i=0;i<4;i++) {
            int there_y = here_y + direction[i][0];
            int there_x = here_x + direction[i][1];

            if(!(there_y<1 || there_y>N || there_x<1 || there_x>M)) {
                if(visited[there_y][there_x]==-1 && map[there_y][there_x]==0) {
                    dfs(there_y,there_x);
                }
            }
        }
    }
}
