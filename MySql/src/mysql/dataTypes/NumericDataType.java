package mysql.dataTypes;

/**
 * User: Nuno
 * Date: 20-08-2013
 * Time: 23:03
 */
public abstract class NumericDataType extends DataType {
    @Override
    public String format(Object value) {
        return value.toString();
    }
}
