package SimpleTasks;

import java.util.Scanner;

public class Fibonacci {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int start = 1;
        int next = 1;
        if(num < 1){
            System.out.println("number should be > 0");
        } else {
            switch (num) {
                case (1):
                    System.out.println(start);
                    break;
                case (2):
                    System.out.println(next);
                    break;
                default: {
                    int result = 1;
                    for (int i = 3; i <= num; i++) {
                        start = next;
                        next = result;
                        result = next + start;
                    }
                    System.out.println(result);
                }
            }
        }
    }
}
