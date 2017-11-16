import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        //String s[] = br.readLine().split(" ");
        BinaryTree tree = new BinaryTree();

        for(int i=0;i<N;i++) {
            String input = br.readLine();
            String[] inputs = input.split(" ");
            tree.add(inputs[0], inputs[1], inputs[2]);
        }

        tree.PreOrderPrintTree(tree.getRoot());
        System.out.println("");
        tree.InOrderPrintTree(tree.getRoot());
        System.out.println("");
        tree.PostOrderPrintTree(tree.getRoot());
    }
}

class BinaryTree{
    private BinaryNode root;
    private BinaryNode tempNode;

    public BinaryNode getRoot(){
        return root;
    }

    public void add(String parent,String leftChild, String rightChild){
        if(root==null){
            root = new BinaryNode(parent);
            if(!leftChild.equals("."))
                root.setLeft(new BinaryNode(leftChild));
            if(!rightChild.equals("."))
                root.setRight(new BinaryNode(rightChild));
        }else{
            setTempNode(root, parent);
            if(!leftChild.equals("."))
                tempNode.setLeft(new BinaryNode(leftChild));
            if(!rightChild.equals("."))
                tempNode.setRight(new BinaryNode(rightChild));
        }
    }

    public void setTempNode(BinaryNode node,String search){
        if(node.getData().equals(search)){
            tempNode = node;
        }
        if(node.getLeft()!=null){
            setTempNode(node.getLeft(), search);
        }
        if(node.getRight()!=null){
            setTempNode(node.getRight(), search);
        }
    }

    public void PreOrderPrintTree(BinaryNode node)
    {
        if(node == null)
            return;
        System.out.print("" + node.getData());
        PreOrderPrintTree(node.getLeft());
        PreOrderPrintTree(node.getRight());
    }


    public void InOrderPrintTree(BinaryNode node)
    {
        if(node == null)
            return;
        InOrderPrintTree(node.getLeft());
        System.out.print("" + node.getData());
        InOrderPrintTree(node.getRight());
    }


    public void PostOrderPrintTree(BinaryNode node)
    {
        if(node == null)
            return;
        PostOrderPrintTree(node.getLeft());
        PostOrderPrintTree(node.getRight());
        System.out.print("" + node.getData());
    }

}

class BinaryNode{
    private String data;
    private BinaryNode left;
    private BinaryNode right;
    public BinaryNode(String data){
        this.data = data;
    }
    public String getData() {
        return data;
    }
    public void setData(String data) {
        this.data = data;
    }
    public BinaryNode getLeft() {
        return left;
    }
    public void setLeft(BinaryNode left) {
        this.left = left;
    }
    public BinaryNode getRight() {
        return right;
    }
    public void setRight(BinaryNode right) {
        this.right = right;
    }
}