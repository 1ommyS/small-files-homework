import java.math.BigDecimal;
import java.util.ArrayList;

public class BillResult<T> {

    private ArrayList<T> lines;
    private BigDecimal total;

    public BillResult(ArrayList<T> lines, BigDecimal total) {
        this.lines = lines;
        this.total = total;
    }

    public ArrayList<T> getLines() {
        return lines;
    }

    public BigDecimal getTotal() {
        return total;
    }
}
