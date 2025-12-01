package Task9;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileUtils {
    public static List<Integer> readFromFile(File input) {
        List<Integer> lst = new ArrayList<>();
        try (FileReader fr = new FileReader(input)) {
            Scanner sc = new Scanner(fr);
            String[] line = sc.nextLine().split(" ");
            for (String s : line) {
                lst.add(Integer.parseInt(s));
            }
        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
        return lst;
    }
    public static void writeToFile(List<Integer> lst, File output) {
        try (FileWriter fw = new FileWriter(output)) {
            for (Integer el : lst) {
                fw.write(String.valueOf(el));
                fw.write(" ");
            }
        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
}
