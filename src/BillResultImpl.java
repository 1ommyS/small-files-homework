import Contracts.BillResult;

import java.math.BigDecimal;
import java.util.ArrayList;

public class BillResultImpl<T> implements BillResult {
    private ArrayList<T> lines;
    private BigDecimal allTotalPrice;

    public BillResultImpl(ArrayList<T> lines, BigDecimal allTotalPrice) {
        this.lines = lines;
        this.allTotalPrice = allTotalPrice;
    }

    @Override
    public ArrayList<T> getLines() {
        return lines;
    }

    @Override
    public BigDecimal getTotal() {
        return allTotalPrice;
    }

    @Override
    public String toString() {
        return "BillResultImpl{" +
                "lines=" + lines +
                ", allTotalPrice=" + allTotalPrice +
                '}';
    }
}
