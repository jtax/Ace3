import org.junit.Before;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * fileParserTest
 *
 * Contains JUnit Tests for the fileParser Class
 *
 * Created by baird on 18/01/2016.
 */
public class fileParserTest {
    private fileParser fr;
    private List<Integer> expected;

    @Before
    public void setUp() throws Exception {
       fr = new fileParser("inputfile.txt");
       expected = (Arrays.asList(1,256,32768,32769,128,65534,33153));
    }

    @Test
    public void testReadAll() throws Exception {
        assertTrue(listEquals(fr.readAll(), expected));
    }

    @Test(expected = FileNotFoundException.class)
    public void testReadAllInvalidFile() throws Exception {
        fr = new fileParser("wrong.txt");
    }

    @Test
    public void testReadNext() throws Exception {
        assertEquals(fr.readNext(),1);
        assertEquals(fr.readNext(),256);
    }

    @Test
    public void testHasNext() throws Exception {
        assertTrue(fr.hasNext());
    }

    @Test
    public void testHasNextNone(){
        for(int i=0; i<7; i++){
          fr.readNext();
        }
        assertFalse(fr.hasNext());
    }

    private boolean listEquals(List<Integer> list1, List<Integer> list2){
        if (list1.size()==list2.size()){
            for (int i=0; i<list1.size(); i++) {
                if (!list1.get(i).equals(list2.get(i))) {
                    return false;
                }
            }
            return true;
        }
        else{
            return false;
        }
    }
}