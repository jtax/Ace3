package Datasets;

import java.util.HashMap;
import java.util.Hashtable;

/**
 * Datasets.PageTable
 *
 * contains the page table and controls adding and removing of elements.
 * Created by baird on 19/01/2016.
 */
public class PageTable {
    private Hashtable<Integer,Integer> pageTable;
    private int MAXSIZE;

    /**
     * Initialises the pageTable and set the Max Size Limit which should be applied to the table
     * @param size the max size of the table
     */
    public PageTable(int size){
        MAXSIZE = size;
        pageTable = new Hashtable<Integer, Integer>();
    }

    /**
     * Adds a new row to the Page Table unless the table is full where is will return -1
     *
     * @param virtualPage the int representing the page number in virtual memory
     * @param physicalPage the int representing the page number in physical memory
     * @return -1 if the table was full and the row was not added, null if the row was add and a value if the row replaces and existing row
     */
    public int add(int virtualPage, int physicalPage){
        if(pageTable.size()==MAXSIZE+1) return -1;
        return pageTable.put(virtualPage,physicalPage);
    }

    /**
     * Removes a row from the page table
     * @param virtualPage the virtual page number of the row to be removed
     * @return the physical page number if one was associated, null if nothing was associated
     * @throws NullPointerException if the VirtualPage is not present
     */
    public int remove(int virtualPage) throws NullPointerException{
        return pageTable.remove(virtualPage);
    }

    /**
     * Gets the physical page value associated with the virtual page number
     * @param virtualPage the virtual page number to look up
     * @return the value of the physical page number or null if physical page number is stored
     * @throws NullPointerException if the VirtualPage is not present
     */
    public int getPhysical(int virtualPage)throws NullPointerException{
        return pageTable.get(virtualPage);
    }
}