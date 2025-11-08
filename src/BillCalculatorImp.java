import jdk.jshell.spi.ExecutionControl;

import java.math.BigDecimal;
import java.util.ArrayList;

public class BillCalculatorImp implements BillCalculator {
    @Override
    public BillResult<BillLine> calculate(ArrayList<ProductLine> products) {
        ArrayList<BillLine> billLines = new ArrayList<>();
        int error = 0;
        BigDecimal sum = BigDecimal.ZERO;
        for (ProductLine x : products) {
            String name = x.getName();
            BigDecimal unitPrice = x.getUnitPrice();
            int quantuty = x.getQuantity();
            BigDecimal total = Utilits.subtotal(unitPrice, quantuty);
            boolean flag = quantuty > 3;
            billLines.add(new Product(name, quantuty, unitPrice, flag, total));

            for (BillLine line : billLines) {
                sum = sum.add(line.getFinalTotal());
            }
        }
        return new BillResultClass(billLines, sum);
    }
}

