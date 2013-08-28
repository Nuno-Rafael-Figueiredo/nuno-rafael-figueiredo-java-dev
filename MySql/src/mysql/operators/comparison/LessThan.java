package mysql.operators.comparison;

import mysql.operators.IOperator;

/**
 * User: Nuno
 * Date: 04-08-2013
 * Time: 18:43
 */
public class LessThan extends BinaryComparisonOperator {
    public static final LessThan INSTANCE = new LessThan();

    private LessThan() {
        super("<");
    }

    @Override
    public IOperator instance() {
        return INSTANCE;
    }

}
