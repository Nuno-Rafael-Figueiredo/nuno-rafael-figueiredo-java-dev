package mysql;

/**
 * User: Nuno
 * Date: 28-08-2013
 * Time: 16:11
 */
public class InvalidTypeException extends RuntimeException {
    public final Object value;

    public InvalidTypeException(Object value) {
        this.value = value;
    }
}
