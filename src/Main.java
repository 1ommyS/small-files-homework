import service.BillingService;

import java.io.IOException;


public class Main {
    public static void main(String[] args) throws IOException {
        BillingService service = new BillingService();
        service.processBilling();
    }
}