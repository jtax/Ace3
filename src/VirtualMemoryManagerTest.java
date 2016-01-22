import Datasets.LogicalMemory;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by baird on 20/01/2016.
 */
public class VirtualMemoryManagerTest {
    LogicalMemory lm;
    VirtualMemoryManager vmm;

    @Before
    public void setup(){
        lm = new LogicalMemory();
        vmm = new VirtualMemoryManager();
    }
    @Test
    public void testInitialiseLogicalMemory() throws Exception {
        vmm.initialiseLogicalMemory("testinput.txt");
    }

    @Test
    public void testTranslateAddress() throws Exception {
        lm.addAddress(1);
        vmm.translateAddresses();
    }
}