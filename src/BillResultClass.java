import java.math.BigDecimal;
import java.util.ArrayList;

public class BillResultClass implements BillResult<BillLine> {

    private ArrayList<BillLine> arrayList;
    private BigDecimal bigDecimal;

    public BillResultClass(ArrayList<BillLine> arrayList, BigDecimal bigDecimal) {
        this.arrayList = arrayList;
        this.bigDecimal = bigDecimal;
    }

    @Override
    public ArrayList<BillLine> getLines() {
        return arrayList;
    }

    @Override
    public BigDecimal getTotal() {
        return bigDecimal;
    }

    @Override
    public String toString() {
        return "BillResultClass{" +
                "arrayList=" + arrayList +
                ", bigDecimal=" + bigDecimal +
                '}';
    }
}
