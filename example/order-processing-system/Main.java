package decorator;

/**
 * Client Class.
 *
 * This class demonstrates how decorators
 * can be combined dynamically at runtime.
 *
 * Execution Flow:
 *
 * TimingDecorator
 *      ->
 * LoggingDecorator
 *      ->
 * BasicOrderService
 *
 * Each decorator adds a new responsibility
 * without modifying the original service.
 */
public class Main {

    public static void main(String[] args) {

        /**
         * Step 1:
         * Create the original core service.
         */
        OrderService service = new BasicOrderService();

        /**
         * Step 2:
         * Wrap the service with logging behavior.
         */
        OrderService loggingService =
                new LoggingDecorator(service);

        /**
         * Step 3:
         * Wrap the logging service with timing behavior.
         *
         * Now the object contains:
         * - logging
         * - execution time monitoring
         * - original business logic
         */
        OrderService timingService =
                new TimingDecorator(loggingService);

        /**
         * Step 4:
         * Execute the final decorated object.
         *
         * The request will pass through
         * all decorator layers.
         */
        timingService.placeOrder("Laptop");
    }
}
