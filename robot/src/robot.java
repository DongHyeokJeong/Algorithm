import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class cleanRobot {
    private static int y,x,d;
    static int[][] direction = {{0,-1}, {-1,0}, {0,1}, {1,0}};
    static int[][] fb_direction = {{-1,0}, {0,1}, {1,0}, {0,-1}};

    public cleanRobot(int R,int C, int D) {
        y = R;
        x = C;
        d = D;
    }

    public void clean(int[][] visited) {
        visited[y][x] = 0;
    }

    public boolean search(int[][] map, int[][] visited, int N, int M) {
        int dy = y + direction[d][0];
        int dx = x + direction[d][1];

        if(!(dy<0 || dx<0 || dy>=N || dx>=M)) {
            if(visited[dy][dx]==-1 && map[dy][dx]==0) {
                return true;
            }
            else {
                return false;
            }
        }
        return false;
    }

    public void rotation() {
        if(d!=0) {
            d--;
        }
        else {
            d=3;
        }
    }

    public void forward() {
        y = y + fb_direction[d][0];
        x = x + fb_direction[d][1];
    }

    public void backward() {
        if(d < 2) {
            y = y + fb_direction[d+2][0];
            x = x + fb_direction[d+2][1];
        }
        else {
            y = y + fb_direction[d-2][0];
            x = x + fb_direction[d-2][1];
        }
    }

    public boolean wall_chk(int[][] map) {
        int dy,dx;

        if(d < 2) {
            dy = y + fb_direction[d+2][0];
            dx = x + fb_direction[d+2][1];
        }
        else {
            dy = y + fb_direction[d-2][0];
            dx = x + fb_direction[d-2][1];
        }

        if(map[dy][dx] == 1) {
            return true;
        }
        else {
            return false;
        }
    }

    public boolean clean_chk(int[][] visited) {
        if(visited[y][x] == 0) {
            return true;
        }
        else {
            return false;
        }
    }
}

public class robot {
    static int N, M;
    static int R, C, D;
    static int[][] map;
    static int[][] visited;

    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s[] = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);

        map = new int[N ][M];
        visited = new int[N][M];

        s = br.readLine().split(" ");
        R = Integer.parseInt(s[0]);
        C = Integer.parseInt(s[1]);
        D = Integer.parseInt(s[2]);

        for (int i = 0; i < N; i++) {
            s = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(s[j]);
                visited[i][j] = -1;
            }
        }

        cleanRobot robot = new cleanRobot(R,C,D);

        boolean start = true;
        boolean noCleanSpot;
        int cnt=0;

        while (start) {
            if(!robot.clean_chk(visited)) {
                robot.clean(visited);
                cnt++;
            }
            noCleanSpot = true;

            for(int i=0;i<4;i++) {
                if (robot.search(map,visited,N,M)) {
                    robot.rotation();
                    robot.forward();
                    noCleanSpot = false;
                    break;
                } else {
                    robot.rotation();
                }
            }

            if(noCleanSpot) {
                if(robot.wall_chk(map)) {
                    start = false;
                }
                else {
                    robot.backward();
                }
            }
        }

        System.out.print(cnt);
        /*for(int i=0;i<N;i++) {
            for(int j=0; j<M; j++) {
                System.out.print(visited[i][j]);
            }
            System.out.println();
        }*/
    }
}
