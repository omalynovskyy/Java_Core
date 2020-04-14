package SimpleTasks;

import java.util.Scanner;

public class SimpleNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int max = scanner.nextInt();
        next:
        for(int n =1;n <= max; n++){
            int j = 0;
            for(int i =2; i <= max; i++){
                if((i*i <= n)&(j != 1)){
                    if(n%i == 0){
                        j=1;
                    }
                }
            }
            if (j != 1){
                System.out.print(n+"; ");
            }
        }
    }
}

