package mysql.statements;

import mysql.Condition;
import mysql.MySql;
import mysql.Table;
import mysql.clauses.*;
import mysql.temp.SelectExpression;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * User: Nuno
 * Date: 04-08-2013
 * Time: 18:04
 */
public class Select extends Statement {
    private final From from;
    private final Where<Select> where;
    private final GroupBy groupBy;
    private final Having having;
    private final OrderBy<Select> orderBy;
    private final Limit<Select> limit;

    private ResultSet result;

    public Select(SelectExpression firstSelectExpression, SelectExpression... otherSelectExpressions) {
        new SelectExpressions(this, firstSelectExpression, otherSelectExpressions);
        from = new From(this);
        where = new Where<>(this);
        groupBy = new GroupBy(this);
        having = new Having(this);
        orderBy = new OrderBy<>(this);
        limit = new Limit<>(this);
    }

    public Select where(Condition condition) {
        return where.add(condition);
    }

    public Select from(Table table) {
        return from.add(table);
    }

    public Select where(Object left, Object right) {
        return where.where(left, right);
    }

    public Select having(Object left, Object right) {
        return having.having(left, right);
    }

    public Select groupBy(Integer... columns) {
        return groupBy.add(columns);
    }

    public Select limit(int offset, int rowCount) {
        return limit.set(offset, rowCount);
    }

    public Select orderBy(Integer... columns) {
        return orderBy.add(columns);
    }

    @Override
    public boolean isValid() {
        return true;
    }

    @Override
    protected void protectedExecute() {
        try(MySql mySql = MySql.INSTANCE.open()){
            PreparedStatement statement = mySql.connection.prepareStatement(toString());
            result = statement.executeQuery();
        } catch (Exception e) {
            severe(e, null);
        }
    }

    public ResultSet getResult() {
        return result;
    }
}
