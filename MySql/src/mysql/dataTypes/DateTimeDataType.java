package mysql.dataTypes;

import java.text.Format;
import java.text.SimpleDateFormat;

/**
 * User: Nuno
 * Date: 28-08-2013
 * Time: 22:21
 */
public abstract class DateTimeDataType extends DataType {
    private Format format;

    public DateTimeDataType(String format) {
        this.format = new SimpleDateFormat(format);
    }

    @Override
    public String format(Object value) {
        return format.format(value);
    }
}
