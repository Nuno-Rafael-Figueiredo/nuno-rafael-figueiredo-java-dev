package mysql;

import design.Base;
import mysql.dataTypes.DataType;

import java.text.MessageFormat;
import java.util.Arrays;

/**
 * User: Nuno
 * Date: 20-08-2013
 * Time: 21:37
 */
public class Column extends Base {
    public boolean is(Property flag) {
        return Arrays.asList(properties).contains(flag);
    }

    public enum Property {
        primaryKey, notNull, unique, binary, unsigned, zeroFilled, autoIncrement
    }

    public final DataType dataType;
    private final Property[] properties;

    public Column(String name, DataType dataType, Property... properties) {
        super(prepare(name));
        this.dataType = dataType;
        this.properties = properties;
    }

    private static String prepare(String name) {
        if (name.charAt(0) == '`' && name.charAt(name.length() - 1) == '`')
            return name;

        if (name.indexOf(' ') < 0)
            return name;

        return MessageFormat.format("`{0}`", name);
    }
}
