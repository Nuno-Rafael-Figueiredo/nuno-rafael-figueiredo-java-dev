package mysql.operators.comparison;

/**
 * User: Nuno
 * Date: 20-08-2013
 * Time: 14:33
 */
public class NullSafeEqual extends BinaryComparisonOperator {
    private static final NullSafeEqual INSTANCE = new NullSafeEqual();

    private NullSafeEqual() {
        super("<=>");
    }

    @Override
    public NullSafeEqual instance() {
        return INSTANCE;
    }
}
