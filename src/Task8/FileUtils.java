package Task8;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class FileUtils {
    public static int[][] readMatrix(File input) {
        int[][] result = null;
        int rowCnt = 1, colCnt = 0;
        try (FileReader fr = new FileReader(input);
            FileReader fr1 = new FileReader(input)) {
            Scanner sc = new Scanner(fr);
            colCnt = sc.nextLine().split(" ").length;
            while (sc.hasNextLine()) {
                sc.nextLine();
                rowCnt++;
            }
            result = new int[rowCnt][colCnt];
            Scanner scan = new Scanner(fr1);
            int j = 0;
            while (scan.hasNextLine()) {
                String[] tmp = scan.nextLine().split(" ");
                int[] row = new int[tmp.length];
                for (int i = 0; i < tmp.length; i++) {
                    row[i] = Integer.parseInt(tmp[i]);
                }
                result[j] = row;
                j++;
            }
        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
        return result;
    }
    public static void writeToFile(int[][] arr, File output) {
        try (FileWriter fw = new FileWriter(output)) {
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr[i].length; j++) {
                    fw.write(String.valueOf(arr[i][j]));
                    fw.write('\t');
                }
                fw.write('\n');
            }
        } catch (Exception ex) {
            System.out.println("Ошибка: " + ex.getMessage());
        }
    }
}
