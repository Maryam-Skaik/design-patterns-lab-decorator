package decorator;

/**
 * Concrete Component in the Decorator Pattern.
 *
 * This class contains the original core business logic
 * of the application.
 *
 * Important:
 * This service only focuses on placing orders.
 *
 * It does NOT handle:
 * - logging
 * - timing
 * - authentication
 * - monitoring
 *
 * Keeping the class clean and focused
 * follows good software engineering principles
 * such as Separation of Concerns.
 */
public class BasicOrderService implements OrderService {

    /**
     * Simulates placing an order in the system.
     *
     * @param product the product being ordered
     */
    @Override
    public void placeOrder(String product) {

        // Core business functionality
        System.out.println("Order placed for: " + product);
    }
}
