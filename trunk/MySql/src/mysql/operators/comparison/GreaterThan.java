package mysql.operators.comparison;

/**
 * User: Nuno
 * Date: 04-08-2013
 * Time: 18:43
 */
public class GreaterThan extends BinaryComparisonOperator {
    public static final GreaterThan INSTANCE = new GreaterThan();

    private GreaterThan() {
        super(">");
    }

    @Override
    public GreaterThan instance() {
        return INSTANCE;
    }
}
