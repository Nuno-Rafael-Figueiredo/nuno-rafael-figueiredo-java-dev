package mysql.clauses;

import mysql.statements.Statement;

/**
 * User: Nuno
 * Date: 04-08-2013
 * Time: 19:50
 */
public class OrderBy<TStatement extends Statement> extends ColumnListClause<TStatement> {
    public OrderBy(TStatement statement) {
        super(statement);
    }
}
