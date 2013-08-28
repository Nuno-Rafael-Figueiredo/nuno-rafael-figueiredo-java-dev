package mysql.operators.comparison;

import mysql.Condition;

/**
 * User: Nuno
 * Date: 23-08-2013
 * Time: 15:27
 */
public abstract class BinaryComparisonOperator extends ComparisonOperator {
    protected BinaryComparisonOperator(String... signs) {
        super(signs);
    }

    public Condition test(Object leftOperand, Object rightOperand) {
        return new Condition(instance(), leftOperand, rightOperand);
    }

}
