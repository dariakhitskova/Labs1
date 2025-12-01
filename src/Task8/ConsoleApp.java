package Task8;

public class ConsoleApp {
    public static void main(String[] args) {
        InputArgs args1 = parseCmdArgs(args);
        if (args1 == null) {
            System.out.println("Аргументы переданы неправильно");
            return;
        }
        int[][] arr = FileUtils.readMatrix(args1.input);
        printMatrix(arr);
        System.out.println();
        Solver.solve(arr);
        printMatrix(arr);
        FileUtils.writeToFile(arr, args1.output);
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
    static void printMatrix(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
