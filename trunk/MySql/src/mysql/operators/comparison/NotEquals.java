package mysql.operators.comparison;

/**
 * User: Nuno
 * Date: 04-08-2013
 * Time: 18:43
 */
public class NotEquals extends BinaryComparisonOperator {
    public static final NotEquals INSTANCE = new NotEquals();

    private NotEquals() {
        super("<>", "!=");
    }

    @Override
    public NotEquals instance() {
        return INSTANCE;
    }
}
