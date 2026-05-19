package decorator;

/**
 * Base Decorator Class.
 *
 * This abstract class acts as the foundation
 * for all concrete decorators.
 *
 * Key Idea:
 * The decorator implements the same interface
 * as the original service.
 *
 * This allows decorators and real services
 * to be treated the same way.
 *
 * The class also stores a reference
 * to another OrderService object.
 *
 * That object can be:
 * - the original service
 * - or another decorator
 *
 * This creates layered wrapping behavior.
 */
public abstract class OrderServiceDecorator implements OrderService {

    /**
     * Reference to the wrapped service object.
     */
    protected OrderService orderService;

    /**
     * Constructor receives the object
     * that should be wrapped.
     *
     * @param orderService the service being decorated
     */
    public OrderServiceDecorator(OrderService orderService) {
        this.orderService = orderService;
    }
}
