import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class cheese {
    static int V, H;
    static int[][] map;
    static int[][] visited;
    static int[][] direction = {{0,1}, {1,0}, {0,-1}, {-1,0}};
    static int N=0; // 치즈 녹는 횟수

    public static void main(String [] args) throws IOException {
        int k=0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String n[] = br.readLine().split(" ");
        V = Integer.parseInt(n[0]);
        H = Integer.parseInt(n[1]);

        map = new int[V+1][H+1];
        visited = new int[V+1][H+1];

        for(int i=1;i<=V;i++) {
            String s[] = br.readLine().split(" ");
            for(int j=1;j<=H;j++) {
                map[i][j] = Integer.parseInt(s[j-1]);
                visited[i][j] = -1;
            }
        }

        while (!isMapZero()) {
            dfs(1,1);
            k = countCheese();
            removeCheese();
            N++;
        }

        System.out.println(N);
        System.out.print(k);
    }

    public static void dfs(int here_y, int here_x) {
        visited[here_y][here_x] = N;

        for(int i=0; i<4; i++) {
            int there_y = here_y + direction[i][0];
            int there_x = here_x + direction[i][1];

            if(!(there_x<1 || there_x>H || there_y<1 || there_y>V)) {
                if(map[there_y][there_x]==1 && visited[there_y][there_x]==-1) {    //치즈이면서 겉부분
                    visited[there_y][there_x] = N+1;
                }
                if(map[there_y][there_x]==0 && visited[there_y][there_x]!=N) {   //공기부분 dfs 탐색
                    dfs(there_y,there_x);
                }
            }
        }
    }

    public static int countCheese() {
        int num=0;
        for (int i=1;i<=V;i++) {
            for(int j=1;j<=H;j++) {
                if(visited[i][j] == N+1) {
                    num++;
                }
            }
        }
        return num;
    }

    public static void removeCheese() {
        for (int i=1;i<=V;i++) {
            for(int j=1;j<=H;j++) {
                if(visited[i][j] == N+1) {        // 만약 지워야할 부분이면
                    map[i][j] = 0;                // 치즈 녹이기
                    visited[i][j] = N;            // 방문 수 하나 낮추기(다음번에 dfs를 적용하기 위해)
                }
                if(map[i][j]==0 && visited[i][j]==-1) {   //만약 치즈 구멍이면
                    visited[i][j] = N;                    // N으로 언제라도 공기를 만나면 녹일 수 있게 하기 위해
                }
            }
        }
    }

    public static boolean isMapZero() {
        int flag = 1;

        for (int i=1;i<=V;i++) {
            for(int j=1;j<=H;j++) {
                if(map[i][j] !=0) {
                    flag = 0;
                    return false;
                }
            }
        }
        return true;
    }
}
