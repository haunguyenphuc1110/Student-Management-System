package control;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author HAU
 */
public class LoggingFunction {

    public void writeFileLog(String filename, String event) {
        try {
            FileWriter fw = new FileWriter(filename, true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.append(event);

            bw.close();
        } catch (IOException e) {

            e.printStackTrace();

        }

    }
//    public static void main(String[] args) {
//        LoggingFunction logging = new LoggingFunction();
//        logging.writeFileLog("log.txt", "Hello\n");
//    }

}
