import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class unitNaming {
    static int[][] map;
    static int[][] visited;
    static int[][] direction = {{0,1}, {1,0}, {0,-1}, {-1,0}};
    static int N;

    public static void main(String [] args) throws IOException {
        int k=0;
        // 입력부
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N+1][N+1];
        visited = new int[N+1][N+1];
        for(int i=1;i<=N;i++) {
            String s[] = br.readLine().split("");
            for(int j=1;j<=N;j++) {
                map[i][j] = Integer.parseInt(s[j-1]);
                visited[i][j] = -1;
            }
        }
        //메인 함수
        k = dfsAll();
        //출력부
        int[] sortingArrays = new int[k+1];
        for(int i=1;i<=N;i++) {
            for(int j=1; j<=N; j++) {
                if(visited[i][j] != -1) {
                    sortingArrays[visited[i][j]] += 1;
                }
            }
        }
        //정렬
        Arrays.sort(sortingArrays);

        System.out.println(k);
        for(int i=1; i<=k;i++) {
            System.out.println(sortingArrays[i]);
        }
    }

    public static void dfs(int here_y, int here_x, int unitNum) {
        visited[here_y][here_x] = unitNum;

        for(int i=0; i<4; i++) {
            int there_y = here_y + direction[i][0];
            int there_x = here_x + direction[i][1];

            if(!(there_x<1 || there_x >N || there_y<1 || there_y>N)) {
                if(map[there_y][there_x] == 1 && visited[there_y][there_x] == -1) {
                    dfs(there_y,there_x,unitNum);
                }
            }
        }
    }

    public static int dfsAll() {
        int unitNum=1;

        for(int i=1;i<=N;i++) {
            for(int j=1;j<=N;j++) {
                if(map[i][j] == 1 &&visited[i][j] == -1) {
                    dfs(i,j,unitNum);
                    unitNum++;
                }
            }
        }
        return unitNum-1;
    }
}
