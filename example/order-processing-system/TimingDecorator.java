package decorator;

/**
 * Concrete Decorator.
 *
 * This decorator adds execution time monitoring
 * around the original service execution.
 *
 * This type of functionality is very common
 * in backend systems for:
 * - performance monitoring
 * - observability
 * - API response tracking
 * - system diagnostics
 */
public class TimingDecorator extends OrderServiceDecorator {

    /**
     * Constructor passes the wrapped service
     * to the parent decorator class.
     *
     * @param orderService the service being wrapped
     */
    public TimingDecorator(OrderService orderService) {
        super(orderService);
    }

    /**
     * Measures execution time before and after
     * the wrapped service executes.
     *
     * @param product the product being ordered
     */
    @Override
    public void placeOrder(String product) {

        // Record start time before execution
        long start = System.currentTimeMillis();

        // Delegate execution to wrapped object
        orderService.placeOrder(product);

        // Record end time after execution
        long end = System.currentTimeMillis();

        // Calculate and display total execution time
        System.out.println("[TIME] Execution time: " + (end - start) + " ms");
    }
}
