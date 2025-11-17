package Task6;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите x (-1; 1): ");
        double x = sc.nextDouble();
        System.out.print("Введите n: ");
        int n = sc.nextInt();
        System.out.print("Введите e: ");
        double e = sc.nextDouble();
        double sum = 0, sumE = 0, sumE10 = 0;
        for (int i = 1; i < n; i++) {
            sum += nTerm(x, i);
        }
        for (int i = 1; i < n; i++) {
            double term = nTerm(x, i);
            if (Math.abs(term) > e) {
                sumE += term;
            }
            if (Math.abs(term) > e / 10) {
                sumE10 += term;
            }
        }

        System.out.println("Значение функции явно: " + f(x));
        System.out.println("Сумма от n слагаемых ряда: " + sum);
        System.out.println("Сумма от n слагаемых ряда больших по модулю e: " + sumE);
        System.out.println("Сумма от n слагаемых ряда больших по модулю e / 10: " + sumE10);
    }

    static double f(double x) {
        return 1 / Math.sqrt(1 + x);
    }

    static double nTerm(double x, int n) {
        if (n == 1) {
            return 1;
        }
        double sign;
        if (n % 2 == 0) {
            sign = -1;
        } else {
            sign = 1;
        }
        double prodCh = 1;
        double prodZn = 1;
        for (int i = 1, k = 0; k < n - 1; i += 2, k++) {
            prodCh *= i;
        }
        for (int i = 2, k = 0; k < n - 1; i += 2, k++) {
            prodZn *= i;
        }
        return sign * prodCh * Math.pow(x, n - 1) / prodZn;
    }
}
