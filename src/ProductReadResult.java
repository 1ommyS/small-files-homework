import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ProductReadResult implements ReadResult<ProductLine> {

    private ArrayList<ProductLine> productLines;
    private int errorCouters;

    public ProductReadResult(ArrayList<ProductLine> productLines,int errorCouters) {
        this.productLines = productLines;
        this.errorCouters = errorCouters;
    }

    private void setError() {
        errorCouters++;
    }

    @Override
    public ArrayList<ProductLine> getItems() {
        return productLines;
    }


    @Override
    public int getErrorCount() {
        return errorCouters;
    }

    @Override
    public String toString() {
        return "ProductReadResult{" +
                "errorCouters=" + errorCouters +
                ", productLines=" + productLines +
                '}';
    }
}
