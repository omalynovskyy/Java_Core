package SimpleTasks;

import java.util.Scanner;

public class SimpleNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int max = scanner.nextInt();
        for(int i=1;(i <= max)&&(i<=4); i++){
            if(i==4){
                continue;
            }
            System.out.print(i+"; ");
         }
        for(int i=5;(i <= max)&&(i<9); i+=2){
            System.out.print(i+"; ");
        }
        for(int i=9;i<=max;i+=2){
            int check = i%3*i%5*i%7*i%9;
            if (check==0) {
                continue;
            }
            System.out.print(i+"; ");
        }

    }
}

