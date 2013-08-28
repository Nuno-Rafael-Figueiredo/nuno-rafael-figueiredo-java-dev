package mysql.operators.comparison;

/**
 * User: Nuno
 * Date: 04-08-2013
 * Time: 18:43
 */
public class LessThanOrEquals extends BinaryComparisonOperator {
    public static final LessThanOrEquals INSTANCE = new LessThanOrEquals();

    private LessThanOrEquals() {
        super("<=");
    }

    @Override
    public LessThanOrEquals instance() {
        return INSTANCE;
    }
}
