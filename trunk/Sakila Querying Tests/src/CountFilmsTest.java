import design.patterns.command.Command;
import mysql.statements.Select;

/**
 * Created with IntelliJ IDEA.
 * User: Nuno
 * Date: 28-08-2013
 * Time: 19:23
 * To change this template use File | Settings | File Templates.
 */
public class CountFilmsTest extends Command.Test<Select> {
    protected CountFilmsTest() {
        super(Films.INSTANCE.countAll());
    }
}
