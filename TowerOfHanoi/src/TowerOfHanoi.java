import java.util.Scanner;

class Num {
    int value=0;

    Num(int value) {
        this.value = value;
    }
}

public class TowerOfHanoi {
    public static void main (String [] args) throws Exception {
        int n;
        char A = 'A';
        char B = 'B';
        char C = 'C';

        Num num = new Num(0);

        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();

        movePlate(n,A,B,C,num);

        System.out.println(num.value);
    }

    public static void movePlate(int n, char frompeg,char topeg, char auxpeg, Num num) {
        num.value=num.value+1;

        if(n == 1) {
            System.out.println("Move disk " + frompeg + " -> " + topeg);
            return;
        }
        else {
            movePlate(n-1,frompeg,auxpeg,topeg,num);
            System.out.println("Move disk " + frompeg + " -> " + topeg);

            movePlate(n-1,auxpeg,topeg, frompeg,num);
        }
    }
}

