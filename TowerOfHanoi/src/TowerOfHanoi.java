import java.util.Scanner;

public class TowerOfHanoi {
    public static void main (String [] args) throws Exception {
        int n;
        int num=0;
        char A = 'A';
        char B = 'B';
        char C = 'C';

        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();

        movePlate(n,A,B,C,num);

        System.out.println(num);
    }

    public static void movePlate(int n, char frompeg,char topeg, char auxpeg, int num) {

        if(n == 1) {
            System.out.println("Move disk " + frompeg + " -> " + topeg);
            num++;
            return;
        }
        else {
            movePlate(n-1,frompeg,auxpeg,topeg,num);
            System.out.println("Move disk " + frompeg + " -> " + topeg);

            movePlate(n-1,auxpeg,topeg, frompeg,num);
        }
    }
}

