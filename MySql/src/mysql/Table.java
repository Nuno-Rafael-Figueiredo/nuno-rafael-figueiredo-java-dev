package mysql;

import design.Base;
import mysql.clauses.SelectExpressions;
import mysql.dataTypes.DataType;
import mysql.statements.Delete;
import mysql.statements.Insert;
import mysql.statements.Select;
import mysql.temp.SelectExpression;

import java.util.*;

/**
 * User: Nuno
 * Date: 04-08-2013
 * Time: 19:21
 */
public abstract class Table extends Base {
    private final Map<String, Column> columns = new LinkedHashMap<>();
    private final PrimaryKey primaryKey = new PrimaryKey();
    public final List<ForeignKey> foreignKeys = new ArrayList<>();

    private DataBase dataBase;

    public Table(DataBase dataBase) {
        super(dataBase.tableNamingPolicies);

        this.dataBase = dataBase;
    }

    protected Column createColumn(String name, DataType dataType, Column.Property... flags) {
        if (containsColumn(name))
            return getColumn(name);

        Column column = new Column(name, dataType, flags);

        for (Column.Property flag : flags)
            if(flag == Column.Property.primaryKey)
                primaryKey.add(column);

        columns.put(name, column);

        return column;
    }

    private Column createColumn(Column referenced, Column.Property[] properties) {
        return createColumn(referenced.name, referenced.dataType, properties);
    }

    protected boolean containsColumn(String columnName) {
        return columns.containsKey(columnName);
    }

    protected Column getColumn(String name) {
        return columns.get(name);
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
        ForeignKey foreignKey = new ForeignKey();

        for (Column referenced : primaryKey){
            Column dependent = createColumn(referenced, properties);
            foreignKey.add(dependent);
        }

        foreignKeys.add(foreignKey);

        return foreignKey;
    }

    public PrimaryKey getPrimaryKey() {
        return primaryKey;
    }

    public Collection<Column> columns() {
        return columns.values();
    }
}
