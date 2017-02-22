import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class tree {
    public class TreeNode {
        public int data;
        public TreeNode firstChild;
        public TreeNode nextSibling;

        TreeNode() {
            this.data = 0;
            this.firstChild = null;
            this.nextSibling = null;
        }

        public int getData() {
            return data;
        }

        public TreeNode getFirstChild() {
            return firstChild;
        }

        public TreeNode getNextSibling() {
            return nextSibling;
        }

        public void setData(int data) {
            this.data = data;
        }

        public void setFirstChild(TreeNode firstChild) {
            this.firstChild = firstChild;
        }

        public void setNextSibling(TreeNode nextSibling) {
            this.nextSibling = nextSibling;
        }
    }

    public static void main (String [] args) throws Exception {
        new tree();
    }

    tree() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] tree_arr = new int[N];

        String str = br.readLine();
        StringTokenizer tokens = new StringTokenizer(str, " ");

        for(int i=0;i<N;i++) {
            tree_arr[i] = Integer.valueOf(tokens.nextToken());
        }

        int K = Integer.parseInt(br.readLine());

     /*   System.out.println(N);
        for(int i=0;i<N;i++) {
            System.out.print(tree[i]);
        }
        System.out.println();
        System.out.println(K);*/

     leafTree(tree_arr,N,K);
    }

    public void leafTree(int[] tree, int N, int K) {
        TreeNode[] link = new TreeNode[N];
        link[0] = new TreeNode();

        for(int i=1;i<N;i++) {
            link[i] = new TreeNode();
            link[i].setData(i);

            if(tree[i] != tree[i-1]) {
                link[i-1].setFirstChild(link[i]);
            }
            else {
                link[i-1].setNextSibling(link[i]);
            }
        }

        // 노드 삭제 하는 부분
        /*deleteLeaf(link,N,K);*/

        //노드 숫자 세는 부분
        /*countLeaf(link, N);*/
        return;
    }

    public void deleteLeaf(TreeNode[] link,int N, int K) {
        for(int i=0;i<N;i++) {
            if(link[i].getData() == K) {

                break;
            }
        }
        return;
    }

    public void countLeaf(TreeNode[] link,int N) {
        int num = 0;

        for(int i=0; i<N; i++) {
            if(link[i].getFirstChild() == null ){
                num++;
            }
        }
        System.out.print(num);
        return;
    }
}
