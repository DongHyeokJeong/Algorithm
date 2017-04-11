import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
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
    /*static int[][] graph;*/
    static final int inf = 999999;
    static ArrayList<Element>[] graph;

    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String n[] = br.readLine().split(" ");

        V = Integer.parseInt(n[0]);
        E = Integer.parseInt(n[1]);
        K = Integer.parseInt(br.readLine());

        dist = new int[V+1];
        graph = new ArrayList[V+1];

        for(int i=1;i<=V;i++) {
            dist[i]=inf;
            graph[i] = new ArrayList<>();
        }

        for(int i=0;i<E;i++) {
            String s[] = br.readLine().split(" ");

            int a = Integer.parseInt(s[0]);
            int b = Integer.parseInt(s[1]);
            int c = Integer.parseInt(s[2]);

            graph[a].add(new Element(b,c));
        }

        /*for(int i=1;i<=V;i++) {
            for(int j=0;j<graph[i].size();j++) {
                System.out.print(i + " " + graph[i].get(j).getIndex() + " ");
                System.out.println(graph[i].get(j).getDistance());
            }
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

            for(int i=0;i<graph[here].size();i++) {
                int there = graph[here].get(i).getIndex();
                int nextDist = cost + graph[here].get(i).getDistance();

                if(dist[there] > nextDist) {
                    dist[there] = nextDist;
                    q.offer(new Element(there,dist[there]));
                }
            }
        }

        for(int i=1;i<=V;i++) {
            if(dist[i] == inf) {
                System.out.print("INF");
            }
            else {
                System.out.print(dist[i]);
            }
            if(i<V) {
                System.out.println();
            }
        }
    }
}
