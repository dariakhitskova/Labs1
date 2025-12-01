package Task10;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileUtils {
    public static List<Flat> readFromFile(File input) {
        List<Flat> flats = new ArrayList<>();
        try (FileReader fr = new FileReader(input)) {
            Scanner sc = new Scanner(fr);
            String line;
            String[] lstLine;
            while ((line = sc.nextLine()) != null) {
                lstLine = line.split(" ");
                flats.add(new Flat(lstLine[0],
                        Integer.parseInt(lstLine[1]),
                        Double.parseDouble(lstLine[2]),
                        Double.parseDouble(lstLine[3]),
                        Integer.parseInt(lstLine[4])));
            }
        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
        return flats;
    }
}
