package mysql.statements;

import mysql.Table;
import mysql.clauses.Limit;
import mysql.clauses.OrderBy;
import mysql.clauses.TableClause;
import mysql.clauses.Where;
import mysql.operators.Operator;

/**
 * User: Nuno
 * Date: 20-08-2013
 * Time: 19:55
 */
public class Delete extends Statement {

    public enum Flag {
        lowPriority, quick, ignore
    }

    public final Table table;
    private final Flag[] flags;

    private final TableClause tableClause;
    private final Where<Delete> where;
    private final OrderBy<Delete> orderBy;
    private final Limit<Delete> limit;

    public Delete(Table table, Flag... flags) {
        this.table = table;
        this.flags = flags;

        // Clauses
        tableClause = new TableClause(this);
        where = new Where<>(this);
        orderBy = new OrderBy<>(this);
        limit = new Limit<>(this);
    }

    public Delete where(Operator operator, Object... arguments) {
        return where.add(operator, arguments);
    }

    public Delete where(Object left, Object right) {
        return where.where(left, right);
    }

    public Delete orderBy(Integer... columns) {
        return orderBy.add(columns);
    }

    public Delete limit(int offset, int rowCount) {
        return limit.set(offset, rowCount);
    }

    @Override
    public boolean isValid() {
        return true;
    }
}
