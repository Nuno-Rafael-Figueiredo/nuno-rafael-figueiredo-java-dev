package mysql.clauses;

import design.Utils;
import mysql.statements.Statement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * User: Nuno
 * Date: 05-08-2013
 * Time: 0:41
 */
public abstract class ColumnListClause<E extends Statement> extends Clause<E> {
    private final List<Integer> columns = new ArrayList<>();

    ColumnListClause(E statement) {
        super(statement);
    }

    public E add(Integer... columns) {
        setUsed();
        this.columns.addAll(Arrays.asList(columns));
        return statement;
    }

    @Override
    public String toString() {
        return super.toString() + " " + Utils.join(columns, ", ");
    }
}
