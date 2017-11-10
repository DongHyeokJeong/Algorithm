import java.util.Scanner;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {

        Stack<Integer> stack = new Stack<Integer>();
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] height = new int [N+1];
        int[] ret = new int [N+1];

        for(int i=1;i<=N;i++) {
            height[i] = sc.nextInt();
        }

        for(int i=N;i>0;i--) {
            while(!stack.isEmpty() && height[stack.peek()]<height[i]) {
                ret[stack.pop()] = i;
            }
            stack.push(i);
        }

        for(int i=1;i<=N;i++) {
            System.out.print(ret[i]+" ");
        }



        sc.close();
    }

}