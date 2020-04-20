package SimpleTasks;

import java.util.Scanner;

public class CountAB {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        count(a,b);
    }
    static void count(int a, int b){
        if(a < b){
            System.out.println(a++);
            count(a,b);
        } else if (a > b){
            System.out.println(a--);
            count(a,b);
        } else System.out.println(a);
    }
}
