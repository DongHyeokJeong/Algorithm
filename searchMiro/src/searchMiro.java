import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class searchMiro {
    static int N, M;
    static int[][] map;
    static int[][] discovered;
    static int[][] direction = {{-1,0}, {0,1}, {1,0}, {0,-1}};

    public static void main(String [] args) throws IOException {
        map = new int[101][101];
        discovered = new int[101][101];

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String n[] = br.readLine().split(" ");
        N = Integer.parseInt(n[0]);
        M = Integer.parseInt(n[1]);

        for (int i = 1; i <= N; i++) {
            String s[] = br.readLine().split("");
            for (int j = 1; j <= M; j++) {
                map[i][j] = Integer.parseInt(s[j-1]);
            }
        }

        for(int i=1;i<=N;i++) {
            for(int j=1;j<=M;j++) {
                discovered[i][j] = -1;
            }
        }

        System.out.println(bfs());
        /*for(int i=1;i<=N;i++) {
            for(int j=1;j<=M;j++) {
                System.out.print(discovered[i][j]);
            }
            System.out.println();
        }*/
    }

    public static class position {
        int y;
        int x;
    }

    public static int bfs() {
        Queue<position> q = new LinkedList<>();

        position init = new position();
        init.y = 1; init.x = 1;
        discovered[1][1] = 1;

        q.offer(init);

        while (!q.isEmpty()) {
            position here = q.poll();

            for(int i=0; i<4; i++) {
                position there = new position();

                there.y = here.y + direction[i][0];
                there.x = here.x + direction[i][1];

                if(!(there.y<1 || there.y>N || there.x<1 || there.x>M)) {
                    if(map[there.y][there.x] == 1) {
                        if(discovered[there.y][there.x] == -1) {
                            discovered[there.y][there.x] = discovered[here.y][here.x] + 1;
                            q.offer(there);
                        }
                        else {
                            if(discovered[there.y][there.x] > discovered[here.y][here.x] + 1) {
                                discovered[there.y][there.x] = discovered[here.y][here.x] + 1;
                            }
                        }
                    }
                }
            }
        }

        return discovered[N][M];
    }
}
