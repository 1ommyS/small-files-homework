package impl;

import interfaces.BillResult;

import java.math.BigDecimal;
import java.util.ArrayList;

public class BillResultImpl<T> implements BillResult<T> {
    private final ArrayList<T> lines;
    private final BigDecimal total;

    public BillResultImpl(ArrayList<T> lines, BigDecimal total) {
        this.lines = lines;
        this.total = total;
    }

    @Override
    public ArrayList<T> getLines() {
        return lines;
    }

    @Override
    public BigDecimal getTotal() {
        return total;
    }
}
