/*import java.util.Scanner;*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class paperCut {

    int paperNum1=0, paperNum0=0, paperNum2=0;  //2가 -1

    public static void main (String [] args) throws Exception {
        new paperCut();
    }

    paperCut() throws IOException {
        /*int N;

        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
        scan.nextLine();

        int[][] paper = new int[N+1][N+1];

        for(int i=1;i<=N;i++) {
            for(int j=1;j<=N;j++) {
                paper[i][j] = scan.nextInt();
            }
        }*/

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] paper = new int[N+1][N+1];
        for (int i = 1; i <= N; i++) {
            String s[] = br.readLine().split(" ");
            for (int j = 1; j <= N; j++) {
                paper[i][j] = Integer.parseInt(s[j-1]);
            }
        }

        /*for(int i=1;i<=N;i++) {
            for(int j=1;j<=N;j++) {
                System.out.print(paper[i][j]);
            }
                System.out.println();
        }*/

        cut(1,1, paper, N);
        System.out.println(paperNum2);
        System.out.println(paperNum0);
        System.out.print(paperNum1);
    }

    public void cut(int x, int y, int[][] paper, int N) {
        //전체 검사
        int c = paper[y][x];
        int flag = 1;

        for(int i=y;i<y+N;i++) {  //검토
            for(int j=x;j<x+N;j++) {
                if(c != paper[i][j]) {
                    flag = 0;
                    break;
                }
            }
            if(flag == 0) {
                break;
            }
        }

        if(flag == 0) {
            //분할 재귀
            int k=(N/3);

            cut(x,y,paper,k);
            cut(k+x,y,paper,k);
            cut(2*k+x,y,paper,k);

            cut(x,k+y,paper,k);
            cut(k+x,k+y,paper,k);
            cut(2*k+x,k+y,paper,k);

            cut(x,2*k+y,paper,k);
            cut(k+x,2*k+y,paper,k);
            cut(2*k+x,2*k+y,paper,k);

        } else {
            if(c==0) {
                paperNum0++;
                return;
            } else if(c==1) {
                paperNum1++;
                return;
            } else {
                paperNum2++;
                return;
            }
        }
    }
}
