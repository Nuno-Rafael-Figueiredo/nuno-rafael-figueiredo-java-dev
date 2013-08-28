package mysql;

import mysql.dataTypes.DataType;
import mysql.dataTypes.Int;
import mysql.dataTypes.Varchar;

/**
 * User: Nuno
 * Date: 20-08-2013
 * Time: 20:20
 */
public class Value {
    public final DataType dataType;
    public final Object value;

    public Value(Object value) {
        this.value = value;
        if (value instanceof String)
            dataType = new Varchar(value.toString().length() + 1);
        else if (value instanceof Integer)
            dataType = new Int();
        else
            throw new InvalidTypeException(value);
    }

    @Override
    public String toString() {
        return dataType.format(value);
    }
}
