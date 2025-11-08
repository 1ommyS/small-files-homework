package itf;

import impl.ProductLineImpl;

import java.util.ArrayList;

public interface ReadResult<T> {
    ArrayList<ProductLineImpl> getItems();

    int getErrorCount();

}
