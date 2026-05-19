package decorator;

/**
 * Concrete Decorator.
 *
 * This decorator adds logging behavior
 * before and after the original service execution.
 *
 * The original business logic itself
 * remains unchanged.
 *
 * This demonstrates one of the biggest advantages
 * of the Decorator Pattern:
 *
 * extending behavior externally
 * without modifying existing code.
 */
public class LoggingDecorator extends OrderServiceDecorator {

    /**
     * Constructor passes the wrapped service
     * to the parent decorator class.
     *
     * @param orderService the service being wrapped
     */
    public LoggingDecorator(OrderService orderService) {
        super(orderService);
    }

    /**
     * Adds logging before and after
     * delegating execution to the wrapped service.
     *
     * @param product the product being ordered
     */
    @Override
    public void placeOrder(String product) {

        // Additional behavior BEFORE execution
        System.out.println("[LOG] Starting order process for: " + product);

        // Delegate execution to the wrapped object
        orderService.placeOrder(product);

        // Additional behavior AFTER execution
        System.out.println("[LOG] Order process finished for: " + product);
    }
}
