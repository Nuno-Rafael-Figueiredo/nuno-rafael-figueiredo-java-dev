package mysql.dataTypes;

import java.text.SimpleDateFormat;

/**
 * User: Nuno
 * Date: 20-08-2013
 * Time: 23:03
 */
public class Date extends DateTimeDataType {

    public Date() {
        super(new SimpleDateFormat("YYYY-MM-DD"));
    }
}
