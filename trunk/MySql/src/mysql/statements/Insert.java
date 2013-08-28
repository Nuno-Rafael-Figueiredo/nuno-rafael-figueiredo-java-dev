package mysql.statements;

import design.Utils;
import mysql.Column;
import mysql.Table;
import mysql.Value;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * User: Nuno
 * Date: 20-08-2013
 * Time: 19:55
 */
public class Insert extends Statement {
    public final Table table;
    private final Column[] columns;
    private final List<Value> values = new ArrayList<>();

    public Insert(Table table, Column... columns) {
        this.table = table;
        this.columns = columns;
    }

    public Insert values(Object... values) {
        for (Object value : values)
            this.values.add(value instanceof Value ? (Value) value : new Value(value));

        return this;
    }

    @Override
    public String toString() {
        return MessageFormat.format("{0}INTO {1} ({2}) VALUES ({3})",
                super.toString(),
                table.name,
                Utils.join(columns, ", "),
                Utils.join(values, ", "));
    }

    @Override
    public boolean isValid() {
        boolean valid = true;

        if (columns.length != values.size()) {
            severe("Number of columns mismatch number of values ({0} != {1})", this, columns.length, values.size());
            valid = false;
        }

        List<Column> list = Arrays.asList(columns);
        for (Column column : table.columns())
            if (list.contains(column)) {
                int index = list.indexOf(column);
                Value value = values.get(index);
                if (value.dataType != column.dataType) {
                    severe("Type mismatch. {0} is type {1}. {2} is type {3}",
                            column,
                            column.dataType,
                            value,
                            value.dataType);
                    valid = false;
                }
            } else {
                if (column.is(Column.Property.notNull)) {
                    severe("Column `{0}` is notNull", column);
                    valid = false;
                }
            }

        if (!valid)
            severe(new RuntimeException("Validation failed"), null);

        return valid;
    }
}
