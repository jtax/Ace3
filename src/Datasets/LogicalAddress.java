package Datasets;

/**
 * Created by baird on 20/01/2016.
 */
public class LogicalAddress {
        int pageNumber, offset;
        public LogicalAddress(int pageNo, int offset){
            this.pageNumber = pageNo;
            this.offset = offset;
        }

        @Override
        public String toString() {
            return "P: " + pageNumber + ", O: " + offset;
        }

    public int getPageNumber(){
        return pageNumber;
    }

    public int getOffset(){
        return offset;
    }
}
