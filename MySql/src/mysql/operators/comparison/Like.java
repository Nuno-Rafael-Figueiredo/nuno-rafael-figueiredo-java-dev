package mysql.operators.comparison;

/**
 * User: Nuno
 * Date: 04-08-2013
 * Time: 18:43
 */
public class Like extends BinaryComparisonOperator {
    public static final Like INSTANCE = new Like();

    @Override
    public Like instance() {
        return INSTANCE;
    }
}
