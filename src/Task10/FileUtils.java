package Task10;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class FileUtils {
    public static List<Flat> readFromFile(File input) {
        List<Flat> flats = new ArrayList<>();
        try (FileReader fr = new FileReader(input)) {
            Scanner sc = new Scanner(fr);
            String line;
            String[] lstLine;
            while (sc.hasNextLine()) {
                line = sc.nextLine();
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
    public static void writeToFile(Map<String, DistrictRooms> map, File output) {
        try (FileWriter fw = new FileWriter(output)) {
            for (DistrictRooms dr : map.values()) {
                fw.write("Район: " + dr.district + " комнат: "
                        + dr.numRooms + " средняя цена за квадратный метр: " + dr.avg() + "\n");
            }
        } catch (IOException ex) {
            System.out.println("Ошибка: " + ex.getMessage());
        }
    }
}
