package SimpleTasks;

import java.util.Scanner;

public class Piramid {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int row = scanner.nextInt();
        int i=1;
        while(i<=row){
            for(int j = 1; j<=(i*2 - 1); j++){
                System.out.print("*");
            }
            i++;
            System.out.println("");
        }

    }
}
