package SimpleTasks;

import java.util.Scanner;

public class CountAB {


    public static void main(String[] args) {
        int[][] ar = new int[4][3];
//        Scanner scanner = new Scanner(System.in);
//        int a = scanner.nextInt();
//        int b = scanner.nextInt();
//        count(a,b);
        System.out.println(ar.length);
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
