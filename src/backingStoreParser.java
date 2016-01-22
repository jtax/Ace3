import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by baird on 21/01/2016.
 */
public class backingStoreParser {

    File input;
    RandomAccessFile backingStore;

    public backingStoreParser() {
        input = new File("BACKING_STORE");
        if(!input.exists()){
            generateNewBackingStore();
        }
        try {
            backingStore = new RandomAccessFile(input, "r");
        } catch (FileNotFoundException e) {
            System.err.println("Backing Store is missing and could not be created");
            System.exit(1);
        }
    }

    public byte[] readBackingStore(int position){
        byte[] read = new byte[256];
        try {
            backingStore.read(read,position*256,256);
        } catch (IOException e) {
            System.err.println("Backing Store Read Error");
            System.exit(1);
        }
        return read;
    }

    /**
     * Taken from MakeBACKING_STORE.java file
     *
     * @author Gagne, Galvin, Silberschatz
     * Operating System Concepts with Java - Eighth Edition
     * Copyright John Wiley & Sons - 2010.
     */
    public void generateNewBackingStore() {
        File fileName;
        RandomAccessFile disk = null;

            fileName = new File("BACKING_STORE");
        try {
            disk = new RandomAccessFile(fileName, "rw");


        for (int i = 0; i < 256*256/4; i++) {
                disk.writeInt(i);
            }
                disk.close();
        } catch (FileNotFoundException e) {
            System.err.println("Backing Store is missing and could not be created");
            System.exit(1);
        } catch (IOException ie){
            System.err.println("Backing Store is missing and could not be created");
            System.exit(1);
        }
    }
}


