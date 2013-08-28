package mysql.clauses;

import mysql.statements.Select;

/**
 * User: Nuno
 * Date: 04-08-2013
 * Time: 19:47
 */
public class GroupBy extends ColumnListClause<Select> {

    public GroupBy(Select statement) {
        super(statement);
    }

}
