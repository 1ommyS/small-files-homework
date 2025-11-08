import java.math.BigDecimal;
import java.util.ArrayList;

public class BillResultlmpl<T> implements BillResult{

    private ArrayList<T> lines;
    private BigDecimal total;

    public BillResultlmpl(ArrayList<T> lines, BigDecimal total) {
        this.lines = lines;
        this.total = total;
    }

    @Override
    public ArrayList getLines() {
        return lines;
    }

    @Override
    public BigDecimal getTotal() {
        return total;
    }
}
