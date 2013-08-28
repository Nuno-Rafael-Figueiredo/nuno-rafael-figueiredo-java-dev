package mysql.dataTypes;

import java.text.MessageFormat;

/**
 * User: Nuno
 * Date: 20-08-2013
 * Time: 21:22
 */
public abstract class StringType extends DataType {

    @Override
    public String format(Object value) {
        return MessageFormat.format("''{0}''", value);
    }
}
