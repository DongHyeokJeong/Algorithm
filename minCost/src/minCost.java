import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

class Element implements Comparable<Element> {
    private int index;
    private int distance;

    Element(int index, int distance) {
        this.index = index;
        this.distance = distance;
    }

    public int getIndex(){
        return index;
    }

    public int getDistance(){
        return distance;
    }
    @Override
    public int compareTo(Element o){
        return distance <= o.distance ? -1 : 1;
    }
}

public class minCost {
    static int[][] graph;
    static int[] dist;
    static int V, E, start, end;
    static final int INF = 999999999;

    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        V = Integer.parseInt(br.readLine());
        E = Integer.parseInt(br.readLine());

        graph = new int[V+1][V+1];
        dist = new int[V+1];

        for(int i=1;i<=V;i++) {
            dist[i] = INF;
            for(int j=1;j<=V;j++) {
                graph[i][j] = INF;
            }
        }

        for(int i=0;i<E;i++) {
            String s[] = br.readLine().split(" ");
            if(graph[Integer.parseInt(s[0])][Integer.parseInt(s[1])] > Integer.parseInt(s[2])) {
                graph[Integer.parseInt(s[0])][Integer.parseInt(s[1])] = Integer.parseInt(s[2]);
            }
        }

        String n[] = br.readLine().split(" ");
        start = Integer.parseInt(n[0]);
        end = Integer.parseInt(n[1]);

        d(start);

		/*for(int i=1;i<=V;i++) {
			System.out.print(dist[i] + " ");
		}*/
        System.out.print(dist[end]);
    }

    public static void d(int start) {
        PriorityQueue<Element> q = new <Element> PriorityQueue();
        dist[start] = 0;
        q.offer(new Element(start,dist[start]));

        while(!q.isEmpty()) {
            int cost = q.peek().getDistance();
            int here = q.peek().getIndex();
            q.poll();

            if(dist[here] < cost) continue;

            for(int i=1;i<=V;i++) {
                if(graph[here][i] != INF) {
                    int there = i;
                    int nextDist = cost + graph[here][i];

                    if(dist[there] > nextDist) {
                        dist[there] = nextDist;
                        q.offer(new Element(there,nextDist));
                    }
                }
            }
        }
    }
}
