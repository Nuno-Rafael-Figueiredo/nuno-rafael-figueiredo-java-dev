package mysql.operators.temp;

import mysql.operators.Operator;

/**
 * User: Nuno
 * Date: 20-08-2013
 * Time: 14:11
 */
public class Interval extends Operator {
    private static final Interval INSTANCE = new Interval();

    private Interval() {
        super(Type.leftBinary, 17000);
    }

    @Override
    public Interval instance() {
        return INSTANCE;
    }
}
