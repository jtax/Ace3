package Datasets;

import java.util.Collection;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by baird on 20/01/2016.
 */
public class TranslationLookasideBuffer {
    Queue<bufferElement> tlb;
    int MAXSIZE;

    public TranslationLookasideBuffer(int size){
        tlb = new LinkedList<bufferElement>();
        MAXSIZE = size;
    }

    public void addElement(int page, int frame){
        bufferElement element = new bufferElement(page,frame);
        if (tlb.size() == MAXSIZE){
            tlb.remove();
        }
        tlb.add(element);
    }


            private class bufferElement{
        private int page;
                private int frame;
                public bufferElement(int page, int frame){
                    this.page = page;
                    this.frame =frame;
                }
    }
}
