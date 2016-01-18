import java.util.List;

/**
 * Created by baird on 18/01/2016.
 */
public class test {

    public static void main(String[] args){
        fileReader fr = new fileReader("inputfile.txt");
        List<Integer> output = fr.readAll();
        while(fr.hasNext()){
            System.out.println(fr.readNext());
        }
    }
}
