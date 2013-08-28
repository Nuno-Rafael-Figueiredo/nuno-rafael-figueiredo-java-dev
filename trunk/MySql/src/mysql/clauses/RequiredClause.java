package mysql.clauses;

import mysql.statements.Statement;

/**
 * User: Nuno
 * Date: 21-08-2013
 * Time: 16:40
 */
public class RequiredClause<E extends Statement> extends Clause<E> {
    protected RequiredClause(String name, E statement) {
        super(name, statement, true);
    }

    public RequiredClause(E statement) {
        super(statement, true);
    }
}
