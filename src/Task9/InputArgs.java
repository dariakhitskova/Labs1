package Task9;

import java.io.File;

public class InputArgs {
    File input, output;

    public InputArgs(String inputStr, String outputStr) {
        input = new File(inputStr);
        output = new File(outputStr);
    }
}
