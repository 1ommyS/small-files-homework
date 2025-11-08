package impl;

import itf.BillLine;
import itf.BillResult;

import java.math.BigDecimal;
import java.util.ArrayList;
//Результат расчёта счёта.

public class BillResultImpl implements BillResult<BillLine> {

    private ArrayList<BillLine> lines;
    private BigDecimal total;

    public BillResultImpl(ArrayList<BillLine> lines, BigDecimal total) {
        this.lines = lines;
        this.total = total;
    }

    @Override
    public ArrayList<BillLine> getLines() {
        return lines;
    }

    @Override
    public BigDecimal getTotal() {
        return total;
    }
}
