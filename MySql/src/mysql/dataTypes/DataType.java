package mysql.dataTypes;

import design.Base;

import java.text.MessageFormat;

/**
 * User: Nuno
 * Date: 20-08-2013
 * Time: 20:16
 */
public abstract class DataType extends Base {
    public abstract String format(Object value);
}
