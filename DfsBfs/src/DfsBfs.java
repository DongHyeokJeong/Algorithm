import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DfsBfs {
    static int[][] graph;
    static int[] visited;
    static int[] discovered;
    static int N,M,V;
    static int[] bfs_path;
    static int[] dfs_path;
    static int[] q;
    static int dfs_path_num=0;

    public static void main(String [] args) throws IOException {
        graph = new int[1001][1001];
        visited = new int[1001];
        discovered = new int[1001];
        dfs_path = new int[1001];
        bfs_path = new int[1001];

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String n[] = br.readLine().split(" ");
        N = Integer.parseInt(n[0]);
        M = Integer.parseInt(n[1]);
        V = Integer.parseInt(n[2]);

        for(int i=1;i<=N;i++) {
            for(int j=1;j<=N;j++) {
                graph[i][j] = 0;
            }
            visited[i] = -1;
            discovered[i] = -1;
        }

        for(int i=1;i<=M;i++) {
            String s[] = br.readLine().split(" ");
            for(int j=1;j<2;j++) {
                int a = Integer.parseInt(s[j-1]);
                int b = Integer.parseInt(s[j]);

                graph[a][b] = 1;
                graph[b][a] = 1;
            }
        }

        bfs_path[0] = V;
        dfs_path[0] = V;

        /*for(int i=1;i<=N;i++) {
            for(int j=1;j<=N;j++) {
                System.out.print(graph[i][j]);
            }
            System.out.println();
        }*/

        dfs(V);
        bfs();

        for(int i=0;i<N;i++) {
            System.out.print(dfs_path[i]);
            if(i != N-1) {
                System.out.print(" ");
            }
        }
        System.out.println();
        for(int i=0;i<N;i++) {
            System.out.print(bfs_path[i]);
            if(i != N-1) {
                System.out.print(" ");
            }
        }
    }

    public static void bfs() {
        q = new int[100000];
        int f=0;
        int r=0;
        int path_num = 1;

        q[0] = V;
        r++;
        discovered[V] = 1;

        while (f != r) {
            int here = q[f];
            f++;

            for(int i=1;i<=N;i++) {
                if(graph[here][i] == 1) {
                    if(discovered[i] == -1) {
                        discovered[i] = discovered[here] + 1;
                        q[r] = i;
                        r++;

                        bfs_path[path_num] = i;
                        path_num++;
                    }
                }
            }
        }


    }

    public static void dfs(int here) {
        visited[here] = 1;
        dfs_path[dfs_path_num] = here;
        dfs_path_num++;

        for(int i=1; i<=N; i++) {
            if(graph[here][i] == 1) {
                int there = i;

                if(visited[there] == -1) {
                    dfs(there);
                }
            }
        }
    }
}
