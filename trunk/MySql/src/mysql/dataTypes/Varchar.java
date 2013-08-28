package mysql.dataTypes;

/**
 * User: Nuno
 * Date: 20-08-2013
 * Time: 20:19
 */
public class Varchar extends StringType {
    public final int maximumLength;

    public Varchar(int maximumLength) {

        this.maximumLength = maximumLength;
    }
}
