package SimpleTasks;

import java.util.Scanner;

public class SimpleNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int max = scanner.nextInt();
        for(int i=1;(i <= max)&&(i<9); i+=2){
            System.out.print(i+"; ");
         }

        for(int i=9;i<=max;i+=2){
            int check = i%3*i%5*i%7;
            if ((check==0)|(Math.sqrt(i)%1==0)) {
                continue;
            }
            System.out.print(i+"; ");
        }

    }
}

