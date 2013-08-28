package mysql.clauses;

import mysql.operators.comparison.Equals;
import mysql.statements.Statement;

/**
 * User: Nuno
 * Date: 04-08-2013
 * Time: 18:10
 */
public class Where<E extends Statement> extends ConditionalClause<E> {

    public Where(E statement) {
        super(statement);
    }

    public E where(Object left, Object right) {
        add(Equals.INSTANCE.test(left, right));

        return statement;
    }

}
