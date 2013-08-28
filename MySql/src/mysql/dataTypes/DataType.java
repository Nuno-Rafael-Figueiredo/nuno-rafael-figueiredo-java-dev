package mysql.dataTypes;

import design.Base;

import java.text.MessageFormat;

/**
 * User: Nuno
 * Date: 20-08-2013
 * Time: 20:16
 */
public abstract class DataType extends Base {
    protected enum FormatMode {
        doNothing, stringify
    }

    public final FormatMode formatMode;

    protected DataType(FormatMode formatMode) {
        this.formatMode = formatMode;
    }

    protected DataType() {
        this(FormatMode.doNothing);
    }

    public String format(Object value) {
        switch (formatMode) {
            case stringify:
                return MessageFormat.format("''{0}''", value);
            default:
                return value.toString();
        }
    }
}
