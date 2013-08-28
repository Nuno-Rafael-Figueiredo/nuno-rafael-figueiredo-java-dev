package mysql.operators.comparison;

/**
 * User: Nuno
 * Date: 04-08-2013
 * Time: 18:43
 */
public class In extends BinaryComparisonOperator {
    public static final In INSTANCE = new In();

    private In() {
    }

    @Override
    public In instance() {
        return INSTANCE;
    }
}
