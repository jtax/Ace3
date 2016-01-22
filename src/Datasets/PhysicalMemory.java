package Datasets;

import java.util.ArrayList;

/**
 * Created by baird on 19/01/2016.
 */
public class PhysicalMemory {
    private byte[][] physicalMemory;

    public PhysicalMemory(int frames, int framesize){
        physicalMemory = new byte[frames][framesize];
    }

    public byte[] read(int position){
        return physicalMemory[position];
    }

    public int nextFreeSpace(){
        for(int i = 0; i < physicalMemory.length; i++){
            if(physicalMemory[i].length == 0){
                return i;
            }
        }
        return -1;
    }

    public int write(byte[] data) {
        int pos = nextFreeSpace();
        if (pos == -1) {
            //No Free Space
            System.err.println("No Free Space");
            System.exit(1);
        } else {
            physicalMemory[pos] = data;
        }
        return pos;
    }
}
