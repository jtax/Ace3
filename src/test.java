import java.io.FileNotFoundException;
import java.util.Arrays;

/**
 * Test Class
 *
 * Designed to ensure the File Reader was acting as expected
 * Created by baird on 18/01/2016.
 */
public class test {

    public static void main(String[] args){
        LogicalMemory logicalMemory = new LogicalMemory();

        try {
           fileParser fr = new fileParser("inputfile.txt");

        while(fr.hasNext()){
            logicalMemory.addAddress(fr.readNext());
        }
        System.out.println(logicalMemory);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
