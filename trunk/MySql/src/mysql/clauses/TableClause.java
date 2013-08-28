package mysql.clauses;

import mysql.statements.Delete;

/**
 * User: Nuno
 * Date: 21-08-2013
 * Time: 16:30
 */
public class TableClause extends RequiredClause<Delete> {
    public TableClause(Delete delete) {
        super(delete.table.name, delete);
    }
}
