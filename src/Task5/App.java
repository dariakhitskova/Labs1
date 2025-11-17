package Task5;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int s = scanner.nextInt();
        int cntSpL = s / 2;
        int n = 0;
        int diff = -1;
        for (int i = 0; i < s / 2; i++) {
            for (int j = 0; j < s; j++) {
                if (i == 0 && j != s / 2) {
                    System.out.print(" ");
                } else if (i == 0 && j == s / 2) {
                    System.out.print(n);
                    n++;
                }
                else if (j < cntSpL) {
                    System.out.print(" ");
                } else if (j == cntSpL) {
                    if (n > 9) {
                        n = 0;
                    }
                    diff = s / 2 - j - 1;
                    System.out.print(n);
                    n++;
                } else if (j == s / 2) {
                    if (n > 9) {
                        n = 0;
                    }
                    System.out.print(n);
                    n++;
                } else if (j > s / 2 && j < s - cntSpL) {
                    if (j <= s / 2 + diff) {
                        System.out.print(" ");
                    } else {
                        if (n > 9) {
                            n = 0;
                        }
                        System.out.print(n);
                        n++;
                    }

                } else {
                    System.out.print(" ");
                }
            }
            cntSpL--;
            System.out.println();
        }
        for (int i = 0; i < s; i++) {
            if (n > 9) {
                n = 0;
            }
            System.out.print(n);
            n++;
        }
        System.out.println();
        cntSpL = 1;
        for (int i = 0; i < s / 2; i++) {
            for (int j = 0; j < s; j++) {
                if (i == s / 2 - 1 && j != s / 2) {
                    System.out.print(" ");
                } else if (i == s / 2 - 1 && j == s / 2) {
                    System.out.print(n);
                    n++;
                }
                else if (j < cntSpL) {
                    System.out.print(" ");
                } else if (j == cntSpL) {
                    if (n > 9) {
                        n = 0;
                    }
                    diff = s / 2 - j - 1;
                    System.out.print(n);
                    n++;
                } else if (j == s / 2) {
                    if (n > 9) {
                        n = 0;
                    }
                    System.out.print(n);
                    n++;
                } else if (j > s / 2 && j < s - cntSpL) {
                    if (j <= s / 2 + diff) {
                        System.out.print(" ");
                    } else {
                        if (n > 9) {
                            n = 0;
                        }
                        System.out.print(n);
                        n++;
                    }

                } else {
                    System.out.print(" ");
                }
            }
            cntSpL++;
            System.out.println();
        }
    }
}
