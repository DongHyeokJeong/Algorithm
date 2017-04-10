import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

class Element implements Comparable<Element>{
    private int index;
    private int distance;

    Element(int index, int distance){
        this.index = index;
        this.distance = distance;
    }

    public int getIndex(){
        return index;
    }

    public int getDistance(){
        return distance;
    }

    public int compareTo(Element o){
        return distance <= o.distance ? -1 : 1;
    }
}

public class shortPath {
    static int V, E, K;
    static int[] dist;
    static int[][] graph;
    static final int inf = 99999;

    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String n[] = br.readLine().split(" ");

        V = Integer.parseInt(n[0]);
        E = Integer.parseInt(n[1]);
        K = Integer.parseInt(br.readLine());

        dist = new int[V+1];
        graph = new int[V+1][V+1];

        for(int i=1;i<=V;i++) {
            for(int j=1;j<=V;j++) {
                graph[i][j] = inf;
            }
            dist[i]=inf;
        }

        for(int i=0;i<E;i++) {
            String s[] = br.readLine().split(" ");

            int a = Integer.parseInt(s[0]);
            int b = Integer.parseInt(s[1]);
            int c = Integer.parseInt(s[2]);
            int preVal = graph[a][b];

            if(preVal > c) {
                graph[a][b] = c;       // a->b, 가중치는 c
            }
        }

        /*for(int i=1;i<=V;i++) {
            for(int j=1;j<=V;j++) {
                System.out.println(graph[i][j]);
            }
            System.out.println();
        }*/

        dijkstra(K);
    }

    public static void dijkstra(int start) {
        PriorityQueue<Element> q = new <Element> PriorityQueue();
        dist[start] = 0;
        q.offer(new Element(start,dist[start]));

        while (!q.isEmpty()) {
            int cost = q.peek().getDistance();
            int here = q.peek().getIndex();
            q.poll();

            if(cost>dist[here]) continue;

            for(int i=1;i<=V;i++) {
                if(graph[here][i] != inf && dist[i]>dist[here]+graph[here][i]) {
                    dist[i] = dist[here] + graph[here][i];
                    q.offer(new Element(i,dist[i]));
                }
            }
        }

        System.out.println();
        for(int i=1;i<=V;i++) {
            if(dist[i] == inf) {
                System.out.println("INF");
            }
            else {
                System.out.println(dist[i]);
            }
        }
    }
}
