import Datasets.*;

import java.io.FileNotFoundException;

/**
 * Created by baird on 20/01/2016.
 */
public class VirtualMemoryManager {
    final static int pageTableLimit = 2^8;
    final static int pageSize = 2^8;
    final static int tlbTableLimit = 16;
    final static int frameSize = 2^8;
    final static int frameTableLimit = 256;

    private LogicalMemory logicalMemory;
    private PageTable pageTable;
    private TranslationLookasideBuffer tlb;
    private PhysicalMemory physicalMemory;
    private backingStoreParser backingStore;

    public VirtualMemoryManager(){
        logicalMemory = new LogicalMemory();
        pageTable = new PageTable(pageTableLimit);
        tlb = new TranslationLookasideBuffer(tlbTableLimit);
        physicalMemory = new PhysicalMemory(frameTableLimit,frameSize);
        backingStore = new backingStoreParser();
    }

    public void initialiseLogicalMemory(String path)throws FileNotFoundException{
        fileParser fp = new fileParser(path);
        logicalMemory.addAddresses(fp.readAll());
    }

    public void translateAddress(LogicalAddress address){
        int frame = -1;
        try{
            frame = pageTable.getPhysical(address.getPageNumber());
        }catch (NullPointerException e){
            //Page Fault
            System.out.println("Page Fault has occured");
            pageFault(address.getPageNumber());
            translateAddress(address);
        }
            System.out.println("Logical Page: " +address.getPageNumber() + " Virtual Page: " + frame);
    }

    public void translateAddresses(){
        for (LogicalAddress address: logicalMemory.getAll()) {
            translateAddress(address);
        }
    }

    public void pageFault(int page){
        byte[] data = backingStore.readBackingStore(page);
        int frame = physicalMemory.write(data);
        tlb.addElement(page, frame);
        pageTable.add(page, frame);
    }
}
