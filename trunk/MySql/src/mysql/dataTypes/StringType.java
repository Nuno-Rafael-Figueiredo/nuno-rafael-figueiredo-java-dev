package mysql.dataTypes;

/**
 * User: Nuno
 * Date: 20-08-2013
 * Time: 21:22
 */
public abstract class StringType extends DataType {
    protected StringType() {
        super(FormatMode.stringify);
    }
}
