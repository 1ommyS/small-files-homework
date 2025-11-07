package Contracts;

import java.util.ArrayList;

public interface BillCalculator {
    BillResult<BillLine> calculate(ArrayList<ProductLine> products);
}
