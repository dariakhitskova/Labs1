package Task7;

import java.util.Scanner;

public class App {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int choice, N, n;
        System.out.println("1 - Тесты прогнать");
        System.out.println("2 - Ввести массив вручную");
        System.out.print("Выбор: ");
        choice = sc.nextInt();
        if (choice == 1) {
            tests();
        } else if (choice == 2) {
            System.out.print("Введите размер массива: ");
            N = sc.nextInt();
            int[] arr = new int[N];
            fillArray(arr);
            System.out.print("Введите длину подпоследовательности: ");
            n = sc.nextInt();
            printArray(arr);
            System.out.println("Индекс начала последовательности: " + solution(arr, n));
        } else {
            System.out.println("Вы ввели не то число");
        }
    }
    static void fillArray(int[] arr) {
        System.out.print("Вводите элементы массива: ");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
    }
    static void printArray(int[] arr) {
        System.out.println();
        System.out.print("Исходный массив: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    static int solution(int[] arr, int n) {
        int maxSum = 0, maxInd = 0;
        if (n > arr.length) {
            return -1;
        }
        for (int i = 0; i < n; i++) {
            maxSum += arr[i];
        }
        int total = maxSum;
        for (int i = 1; i <= arr.length - n; i++) {
            total = total - arr[i - 1] + arr[i + n - 1];
            if (total > maxSum) {
                maxSum = total;
                maxInd = i;
            }
        }
        return maxInd;
    }
    static void tests() {
        int[] arr1 = { 3, -9, 2, 4, 2, 1, -90, 434, 22 };
        int[] arr2 = { 3, -9, 2, 4, 2, -1, -90 };
        int[] arr3 = { -33, -9, 2, 4, 2, 1, -90 };
        int[] arr4 = { 3, -93, 2, 42, 2, -1, 90 };
        int[] arr5 = { 3, -9, 2, 4, -2, 1, 90 };
        int[] arr6 = { 3, -9, 2, 4, -90 };
        int[] arr7 = { -43, -39, 225, 4, 22, 1, -90 };
        int[] arr8 = { 3, -9, 2, 4, 2, 1, -90 };
        int[] arr9 = { 3, -94, 23, 4, 3, 1, -90 };
        int[] arr10 = { 3, -29, -2, 4, 23, 1, -90, 34, 234 };
        int[] length = { 2, 4, 1, 2, 4, 3, 2, 1, 2, 3 };
        int[][] tests = {
                arr1,
                arr2,
                arr3,
                arr4,
                arr5,
                arr6,
                arr7,
                arr8,
                arr9,
                arr10
        };
        for (int i = 0; i < 10; i++) {
            System.out.println("Тест " + (i + 1) + " результат " + solution(tests[i], length[i]));
        }
    }
}
