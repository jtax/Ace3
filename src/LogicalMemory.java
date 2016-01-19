import java.util.ArrayList;
import java.util.List;

/**
 *
 * Created by baird on 19/01/2016.
 */
public class LogicalMemory {
    private List<LogicalAddress> logicalMemory;

    public LogicalMemory(){
        logicalMemory = new ArrayList<>();
    }

    public void addAddress(int address){
        int addressPart = address & 65535;
        int pageNo = addressPart >> 8;
        int offset = addressPart & 255;
        LogicalAddress logicalAddress = new LogicalAddress(pageNo, offset);
        logicalMemory.add(logicalAddress);
    }

    @Override
    public String toString(){
        String output = "";
        for (LogicalAddress address: logicalMemory) {
            output += "{" + address.toString() + "}\n";
        }
        return output;
    }

    public class LogicalAddress{
        int pageNumber, offset;
        public LogicalAddress(int pageNo, int offset){
            this.pageNumber = pageNo;
            this.offset = offset;
        }

        @Override
        public String toString(){
            return "P: " + pageNumber + ", O: " + offset;
        }
    }
}
