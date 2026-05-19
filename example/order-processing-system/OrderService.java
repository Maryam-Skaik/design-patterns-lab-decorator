package decorator;

/**
 * The Component Interface in the Decorator Pattern.
 *
 * This interface defines the common contract
 * that all order services must follow.
 *
 * Both:
 * - the original service
 * - and all decorators
 *
 * will implement this same interface.
 *
 * This allows decorators to wrap objects
 * while keeping the same structure and behavior contract.
 */
public interface OrderService {

    /**
     * Core business operation.
     *
     * @param product the product being ordered
     */
    void placeOrder(String product);
}
