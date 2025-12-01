package Task9;

import Task9.InputArgs;

import java.io.File;
import java.util.List;

public class ConsoleApp {
    public static void main(String[] args) {
        InputArgs args1 = parseCmdArgs(args);
        if (args1 == null) {
            System.out.println("Аргументы переданы неправильно");
            return;
        }
        List<Integer> lst = FileUtils.readFromFile(args1.input);
        Solver.solve(lst);
        FileUtils.writeToFile(lst, args1.output);
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
