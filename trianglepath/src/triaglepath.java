import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class triaglepath {
    static int n;
    static int[][] traiangle = new int[501][501];
    static int[][] cache = new int[501][501];

    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        for(int i=1;i<=n;i++) {
            String s[] = br.readLine().split(" ");
            for(int j=1;j<=i; j++) {
                traiangle[i][j] = Integer.parseInt(s[j-1]);
            }
        }

        for(int i=1;i<=n;i++) {
            for(int j=1;j<=n;j++) {
                cache[i][j] = -1;
            }
        }

        System.out.print(path2(1,1));
    }

    public static int path2(int y, int x) {
        // 이때 탈출
        if(y == n) { return traiangle[y][x];}
        //메모이제이션
        if(cache[y][x] != -1) {return cache[y][x];}
        //값 리턴
        return cache[y][x] = max(path2(y+1,x),path2(y+1,x+1)) + traiangle[y][x];
    }

    public static int max(int a, int b) { return a>b?a:b;} //최대값 함수
}