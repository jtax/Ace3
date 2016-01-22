package Datasets;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * Created by baird on 19/01/2016.
 */
public class LogicalMemory {
    private List<LogicalAddress> logicalMemory;
    int count;

    public LogicalMemory(){

        count = 0;
        logicalMemory = new ArrayList<>();
    }

    public void addAddress(int address){
        int addressPart = address & 65535;
        int pageNo = addressPart >> 8;
        int offset = addressPart & 255;
        LogicalAddress logicalAddress = new LogicalAddress(pageNo, offset);
        logicalMemory.add(logicalAddress);
    }

    public void addAddresses(List<Integer> addresses){
        for (Integer address: addresses) {
            addAddress(address);
        }
    }

    @Override
    public String toString(){
        String output = "";
        for (LogicalAddress address: logicalMemory) {
            output += "{" + address.toString() + "}\n";
        }
        return output;
    }

    public List<LogicalAddress> getAll(){
        return logicalMemory;
    }

    public LogicalAddress getNext(){
        if(count<logicalMemory.size()) {
            return logicalMemory.get(count);
        }
        return null;
    }

}
