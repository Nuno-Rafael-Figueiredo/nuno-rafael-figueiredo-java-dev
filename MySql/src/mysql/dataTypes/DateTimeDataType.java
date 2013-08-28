package mysql.dataTypes;

import java.text.Format;

/**
 * Created with IntelliJ IDEA.
 * User: Nuno
 * Date: 28-08-2013
 * Time: 22:21
 * To change this template use File | Settings | File Templates.
 */
public abstract class DateTimeDataType extends DataType {
    private Format format;

    public DateTimeDataType(Format format) {
        this.format = format;
    }

    @Override
    public String format(Object value) {
        return format.format(value);
    }
}
