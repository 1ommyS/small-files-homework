import java.util.ArrayList;

public class ReadResult<T> {

    private ArrayList<T> items;
    private int errorCount;

    public ReadResult(ArrayList<T> items, int errorCount) {
        this.items = items;
        this.errorCount = errorCount;
    }

    public ArrayList<T> getItems() {
        return items;
    }

    public int getErrorCount() {
        return errorCount;
    }
}
