package Task4;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(sumPrime(n));
    }
    static int sumPrime(int n){
        int cnt = 0, sum = 0;
        for (int i = 1; cnt < n; i++) {
            if (isPrime(i)) {
                sum += i;
                cnt++;
            }
        }
        return  sum;
    }
    static boolean isPrime(int a){
        if (a < 2) {
            return false;
        }
        for (int i = 2;i <= a-1;i++){
            if( a % i == 0){
                return false;
            }
        }
        return true;
    }
}
