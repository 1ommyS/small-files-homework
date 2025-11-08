package itf;

import impl.ProductLineImpl;

import java.util.ArrayList;

public interface BillCalculator {
    BillResult<BillLine> calculate(ArrayList<ProductLineImpl> products);
}
