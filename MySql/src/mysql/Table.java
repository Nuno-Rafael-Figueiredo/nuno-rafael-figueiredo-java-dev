package mysql;

import design.Base;
import design.NamingPolicy;
import mysql.clauses.SelectExpressions;
import mysql.dataTypes.DataType;
import mysql.statements.Delete;
import mysql.statements.Insert;
import mysql.statements.Select;
import mysql.temp.SelectExpression;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * User: Nuno
 * Date: 04-08-2013
 * Time: 19:21
 */
public abstract class Table extends Base {
    private Map<String, Column> columnMap = new LinkedHashMap<>();

    protected Column createColumn(String name, DataType dataType, Column.Property... flags) {
        if (containsColumn(name))
            return getColumn(name);

        Column column = new Column(name, dataType, flags);

        columnMap.put(name, column);

        return column;
    }

    protected boolean containsColumn(String columnName) {
        return columnMap.containsKey(columnName);
    }

    protected Column getColumn(String name) {
        return columnMap.get(name);
    }

    protected Table() {
        super(NamingPolicy.uppercase);
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

    protected ForeignKey createForeignKey(Table table, Column.Property... properties) {
        PrimaryKey primaryKey = table.getPrimaryKey();
    }
}
