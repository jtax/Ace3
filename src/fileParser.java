import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * fileParser
 * Reads a CSV file to a list of numbers
 * Created by baird on 18/01/2016.
 */
public class fileParser {
    private ArrayList<Integer> vals;
    private int count;

    public fileParser(String path) throws FileNotFoundException{
        File input = new File(path);
        count = 0;
        vals = new ArrayList<>();
        Scanner sc = new Scanner(input);
         while (sc.hasNext()){
                String valueS = sc.next().replaceAll(",","");
                int valueI = Integer.parseInt(valueS);
                vals.add(valueI);
            }
    }

    public List<Integer> readAll(){
        return vals;
    }

    public int readNext(){
        return vals.get(count++);
    }

    public boolean hasNext(){
        return vals.size() > count;
    }
}
