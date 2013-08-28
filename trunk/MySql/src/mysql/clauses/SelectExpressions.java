package mysql.clauses;

import design.Utils;
import mysql.statements.Select;
import mysql.temp.ISelectExpression;
import mysql.temp.SelectExpression;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * User: Nuno
 * Date: 04-08-2013
 * Time: 21:34
 */
public class SelectExpressions extends RequiredClause<Select> {
    public static final SelectExpression ALL = new SelectExpression("*");

    private final List<ISelectExpression> expressions = new ArrayList<>();

    public SelectExpressions(Select statement, ISelectExpression firstSelectExpression, ISelectExpression... otherISelectExpressions) {
        super(statement);

        expressions.add(firstSelectExpression);
        expressions.addAll(Arrays.asList(otherISelectExpressions));
    }

    @Override
    public String toString() {
        return Utils.join(expressions, ", ");
    }
}
