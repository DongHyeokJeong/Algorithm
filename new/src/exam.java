import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Pair {
    int x;
    int y;

    void setPair(int x, int y) {
        x = this.x;
        y = this.y;
    }

    int getX() {
        return this.x;
    }

    int getY() {
        return this.y;
    }
}

public class Main {
    //세로, 가로 크기
    static int n, m;
    //지도 크기
    static int[][] map, originMap;

    //확산을 위한 큐
    static Queue q = new LinkedList();

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        //세로
        n = input.nextInt();
        //가로
        m = input.nextInt();
        //지도 크기
        map = new int[n][m];
        originMap = new int[n][m];

        //최대값
        int max = 0;

        //지도 입력
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                map[i][j] = originMap[i][j] = input.nextInt();
            }
        }

        Spread(map);

        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }

        //3개골라서

        //바이러스 퍼트리기
        Spread(map);

        //안전영역 계산
        int tmp = Safe(map);

        //최대값이면 교체
        if (tmp > max) max = tmp;

        //기존 지도로 교체
        Back(map, originMap);

        System.out.print(max);
    }

    static void Spread(int[][] map) {
        //상하좌우 이동
        int[] moveX = {-1, 1, 0, 0};
        int[] moveY = {0, 0, -1, 1};

        //바이러스 최초 위치 저장
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (map[i][j]==2) {
                    Pair p = new Pair();
                    p.x = i;
                    p.y = j;
                    q.add(p);
                }
            }
        }

        //spread
        while (!q.isEmpty()) {
            Pair tmpPair = (Pair) q.poll();
            int tmpX = tmpPair.getX();
            int tmpY = tmpPair.getY();
//			System.out.println(tmpX + "," + tmpY + " 바이러스!!");

            for (int i=0; i<4; i++) {
                int nextX = tmpX + moveX[i];
                int nextY = tmpY + moveY[i];
                if (nextX>=0 && nextX<n && nextY>=0 && nextY<m) {
                    if (map[nextX][nextY] == 0) {
                        map[nextX][nextY] = 2;
                        Pair newP = new Pair();
                        newP.x = nextX;
                        newP.y = nextY;
                        q.add(newP);
                    }
                }
            }
        }
    }

    static int Safe(int[][] map) {
        int cnt = 0;
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (map[i][j]==0) cnt++;
            }
        }
        return cnt;
    }

    static void Back(int[][] map, int[][] originMap) {
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                map[i][j] = originMap[i][j];
            }
        }
    }
}