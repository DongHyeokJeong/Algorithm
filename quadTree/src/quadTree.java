import java.util.Scanner;

public class quadTree {
    String s = ""; //전역변수

    public static void main (String [] args) throws Exception {
        new quadTree();
    }

    quadTree() {
        int N;

        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
        scan.nextLine();

        int[][] video = new int[N][N];

        for(int i=0;i<N;i++) {
            String str = scan.nextLine();
            for(int j=0;j<N;j++) {
                video[i][j] = str.charAt(j)-'0';
            }
        }

      /*  for(int i=0;i<N;i++) {
            for(int j=0;j<N;j++) {
                System.out.print(video[i][j]);
            }
                System.out.println();
        }*/

        compression(video, N);
        System.out.println(s);
    }

    public void compression(int[][] video, int N) {
        int c = video[0][0];
        int flag = 1;

        for(int i=0;i<N;i++) {  // all 1 or 0 비교
            for(int j=0;j<N;j++) {
                if(c != video[i][j]) {
                    flag = 0;
                    break;
                }
            }
            if(flag == 0) {
                break;
            }
        }

        if(flag == 1) {
            s+=c;
            return;
        }
        else {
            s+='('; // ( 추가

            for(int i=0; i<4; i++) { //4등분
                int[][] dividedVideo = new int[N/2][N/2];

                if(i==0) {
                    for(int j=0;j<(N/2);j++) {
                        for(int t=0;t<(N/2);t++) {
                            dividedVideo[j][t] = video[j][t];
                        }
                    }
                    compression(dividedVideo,N/2);
                }
                else if(i==1) {
                    for(int j=0;j<(N/2);j++) {
                        for(int t=(N/2);t<N;t++) {
                            dividedVideo[j][t-(N/2)] = video[j][t];
                        }
                    }
                    compression(dividedVideo,N/2);
                }
                else if(i==2) {
                    for(int j=(N/2);j<N;j++) {
                        for(int t=0;t<(N/2);t++) {
                            dividedVideo[j-(N/2)][t] = video[j][t];
                        }
                    }
                    compression(dividedVideo,N/2);
                }
                else {
                    for(int j=(N/2);j<N;j++) {
                        for(int t=(N/2);t<N;t++) {
                            dividedVideo[j-(N/2)][t-(N/2)] = video[j][t];
                        }
                    }
                    compression(dividedVideo,N/2);
                }
            }

            s+=')'; // ) 추가
            return;
        }
    }
}
