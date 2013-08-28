package mysql.temp;

/**
 * User: Nuno
 * Date: 04-08-2013
 * Time: 19:45
 */
public class SelectExpression implements ISelectExpression{
    private final String expression;

    public SelectExpression(String expression) {
        this.expression = expression;
    }

    @Override
    public String toString() {
        return expression;
    }
}
