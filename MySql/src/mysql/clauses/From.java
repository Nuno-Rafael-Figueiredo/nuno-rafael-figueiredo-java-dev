package mysql.clauses;

import design.Utils;
import mysql.Table;
import mysql.statements.Select;

import java.util.ArrayList;
import java.util.List;

/**
 * User: Nuno
 * Date: 04-08-2013
 * Time: 18:10
 */
public class From extends Clause<Select> {
    private final List<Table> tableReferences = new ArrayList<>();

    public From(Select statement) {
        super(statement);
    }

    public Select add(Table table) {
        setUsed();
        tableReferences.add(table);
        return statement;
    }

    @Override
    public String toString() {
        return super.toString() + " " + Utils.join(tableReferences, ", ");
    }
}
