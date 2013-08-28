package mysql.operators.comparison;

import mysql.Condition;

/**
 * User: Nuno
 * Date: 04-08-2013
 * Time: 18:43
 */
public class Between extends ComparisonOperator {
    public static final Between INSTANCE = new Between();

    private Between() {
        super(Type.ternary, 6000, "BETWEEN", "AND");
    }

    public Condition test(Object firstOperand, String secondOperand, String thirdOperand) {
        return new Condition(INSTANCE, firstOperand, secondOperand, thirdOperand);
    }

    @Override
    public Between instance() {
        return INSTANCE;
    }
}
