package mysql;

import design.Base;
import design.NamingPolicy;
import mysql.clauses.SelectExpressions;
import mysql.dataTypes.DataType;
import mysql.statements.Delete;
import mysql.statements.Insert;
import mysql.statements.Select;
import mysql.temp.SelectExpression;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * User: Nuno
 * Date: 04-08-2013
 * Time: 19:21
 */
public abstract class Table extends Base {
    protected final Map<String, Column> columnMap = new LinkedHashMap<>();

    protected Table() {
        super(NamingPolicy.uppercase);
    }

    public Column getColumn(String name) {
        return columnMap.get(name);
    }

    public Select selectAll() {
        return select(SelectExpressions.ALL);
    }

    public Insert insert(Column... columns) {
        return new Insert(this, columns);
    }

    private Select select(SelectExpression firstSelectExpressions, SelectExpression... otherSelectExpressions) {
        return new Select(firstSelectExpressions, otherSelectExpressions).from(this);
    }

    public Delete delete() {
        return new Delete(this);
    }

    protected Column createColumn(String name, DataType dataType, Column.Property... flags) {
        if (containsColumn(name))
            return getColumn(name);

        Column column = new Column(name, dataType, flags);

        columnMap.put(name, column);

        return column;
    }

    public Collection<Column> columns() {
        return columnMap.values();
    }

    protected boolean containsColumn(String columnName) {
        return columnMap.containsKey(columnName);
    }
}
