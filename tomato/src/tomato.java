import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class tomato {
    static int N,M;
    static int[][] tomato;
    static int[][] discovered;
    static int[][] direction = {{-1,0}, {0,1}, {1,0}, {0,-1}};

    public static void main(String [] args) throws IOException {
        tomato = new int[1001][1001];
        discovered = new int[1001][1001];

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String n[] = br.readLine().split(" ");
        M = Integer.parseInt(n[0]);
        N = Integer.parseInt(n[1]);

        for(int i=1; i<=N; i++) {
            String s[] = br.readLine().split(" ");
            for(int j=1; j<=M; j++) {
                tomato[i][j] = Integer.parseInt(s[j-1]);
            }
        }

        for(int i=1; i<=N; i++) {
            for(int j=1; j<=M; j++) {
                discovered[i][j] = -1;
            }
        }

        System.out.print(bfs());
    }

    public static class position {
        int x;
        int y;
    }

    public static int bfs() {
        int max = 0;
        Queue<position> q = new LinkedList<>();

        //큐를 채우고
        for(int i=1;i<=N;i++) {
            for(int j=1;j<=M;j++) {
                if(tomato[i][j] == 1) {
                    position init = new position();
                    init.y = i;
                    init.x = j;

                    discovered[init.y][init.x] = 0;

                    q.offer(init);
                }
            }
        }

        while (!q.isEmpty()) {
            position here = q.poll();

            for(int i=0;i<4;i++) {
                position there = new position();

                there.y = here.y + direction[i][0];
                there.x = here.x + direction[i][1];

                if(!(there.y>N || there.y <1 || there.x>M || there.x<1)) {
                    if(tomato[there.y][there.x] == 0) {
                        if(discovered[there.y][there.x] == -1) {
                            discovered[there.y][there.x] = discovered[here.y][here.x]+1;

                            max = (max>=discovered[there.y][there.x] ? max : discovered[there.y][there.x]);

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

        for(int i=1; i<=N; i++) {
            for(int j=1; j<=M; j++) {
                if((tomato[i][j]==0) && (discovered[i][j] == -1)) {
                    max = -1;
                }
            }
        }

        return max;
    }
}