package mysql.operators.comparison;

import mysql.operators.IOperator;

/**
 * User: Nuno
 * Date: 04-08-2013
 * Time: 18:43
 */
public class Equals extends BinaryComparisonOperator {
    public static final Equals INSTANCE = new Equals();

    private Equals() {
        super("=");
    }

    @Override
    public IOperator instance() {
        return INSTANCE;
    }
}
