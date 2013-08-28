package mysql.operators.comparison;

/**
 * User: Nuno
 * Date: 04-08-2013
 * Time: 18:43
 */
public class GreaterThanOrEquals extends BinaryComparisonOperator {
    public static final GreaterThanOrEquals INSTANCE = new GreaterThanOrEquals();

    private GreaterThanOrEquals() {
        super(">=");
    }

    @Override
    public GreaterThanOrEquals instance() {
        return INSTANCE;
    }
}
