package mysql.operators;

/**
 * User: Nuno
 * Date: 20-08-2013
 * Time: 14:12
 */
public interface IOperator {
    IOperator instance();

    String pattern();
}
