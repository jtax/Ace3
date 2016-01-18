import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.util.*;

/**
 * Created by baird on 18/01/2016.
 */
public class fileReader {
    File input;
    ArrayList<Integer> vals;
    int count;

    public fileReader(String path){
        input = new File(path);
        assert (input.exists());
        count = 0;
        vals = new ArrayList<Integer>();
        try {
            Scanner sc = new Scanner(input);
            while (sc.hasNext()){
                String valueS = sc.next().replaceAll(",","");
                int valueI = Integer.parseInt(valueS);
                vals.add(valueI);
            }
        } catch (FileNotFoundException e) {
            System.err.println("The input file could not be found!\nProgram will now close");
            System.exit(1);
        }

    }

    public ArrayList<Integer> readAll(){
        return vals;
    }

    public int readNext(){
        return vals.get(count++);
    }

    public boolean hasNext(){
        return vals.size() > count;
    }
}
