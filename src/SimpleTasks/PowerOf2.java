package SimpleTasks;

import javax.swing.*;
import java.util.Scanner;

public class PowerOf2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        checkPower2(num);

    }
    static void checkPower2(int n){
        if(n/2 == 1){
            System.out.println("Yes");
        } else if(n%2 == 0){
            checkPower2(n/2);
        }  else {
            System.out.println("No");
        }

    }
}
