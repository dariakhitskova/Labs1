package Task10;

import java.util.List;
import java.util.Map;

public class ConsoleApp {
    public static void main(String[] args) {
        InputArgs args1 = parseCmdArgs(args);
        if (args1 == null) {
            System.out.println("Аргументы переданы неправильно");
            return;
        }
        List<Flat> flats = FileUtils.readFromFile(args1.input);
        Map<String, DistrictRooms> map = Solver.solve(flats);
        FileUtils.writeToFile(map, args1.output);
    }
    static InputArgs parseCmdArgs(String[] args) {
        if (args.length == 4 || args.length == 2) {
            if (args.length == 4) {
                if (args[0].equals("-i") && args[2].equals("-o")) {
                    return new InputArgs(args[1], args[3]);
                }
                if (args[2].equals("-i") && args[0].equals("-o")) {
                    return new InputArgs(args[3], args[1]);
                }
            }
            if (args.length == 2) {
                if (args[0].startsWith("--input-file=")
                        && args[1].startsWith("--output-file=")) {
                    String inp = args[0].split("=")[1];
                    String out = args[1].split("=")[1];
                    return new InputArgs(inp, out);
                }
                if (args[0].startsWith("--input-file=")
                        && args[1].startsWith("--output-file=")) {
                    String inp = args[1].split("=")[1];
                    String out = args[0].split("=")[1];
                    return new InputArgs(inp, out);
                }
                return new InputArgs(args[0], args[1]);
            }
            return null;
        }
        return null;
    }
}
