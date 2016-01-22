import Datasets.LogicalMemory;
import Datasets.PageTable;

import java.io.FileNotFoundException;

/**
 * Test Class
 *
 * Designed to ensure the File Reader was acting as expected
 * Created by baird on 18/01/2016.
 */
public class test {

    public static void main(String[] args){
        VirtualMemoryManager vmm = new VirtualMemoryManager();
        try {
            vmm.initialiseLogicalMemory("testinput.txt");
        } catch (FileNotFoundException e) {
            System.err.println("The File Given To The Virtual Memory Manager Does Not Exist");
            System.exit(1);
        }
        vmm.translateAddresses();

    }
}
