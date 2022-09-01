package check;

import org.apache.commons.io.FilenameUtils;

import java.io.FileWriter;

import static org.apache.commons.io.FilenameUtils.getExtension;

public class CheckFileExtension {

    public static boolean checkFile(String file) {
        String ext = getExtension(file);
        if (!ext.equals("csv") || file.length() == 0) {
            System.out.println("the file has the wrong extension");
            try {
                FileWriter output = new FileWriter("Errors");
                output.write(FilenameUtils.getName(file) + " has the wrong extension");
                output.close();
            } catch (Exception e) {
                e.getStackTrace();
            }
            return false;
        }
        System.out.println("this file passed the file extension check");
        return true;

    }
}
