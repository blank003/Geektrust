import parser.InputParser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Index {


    public static void main(String[] args) throws IOException {

        InputParser inputParser = new InputParser();
        if (args.length == 0) {
            inputParser.parseViaCommandLine();
        }
        else {
            BufferedReader br = null;
            try {
                File inFile = new File(args[0]);
                if(inFile!=null) {
                    br = new BufferedReader(new FileReader(inFile));
                    inputParser.parseViaFile(br);
                }
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
