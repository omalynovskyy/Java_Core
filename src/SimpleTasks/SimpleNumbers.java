package SimpleTasks;

import java.util.Scanner;

public class SimpleNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int max = scanner.nextInt();
        for(int i=0;i <= max; i++){
            System.out.print(i+"; ");
        }
    }
}

