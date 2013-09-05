import design.patterns.command.Command;
import mysql.statements.Select;
import sakila.model.Sakila;

/**
 * User: Nuno
 * Date: 28-08-2013
 * Time: 16:19
 */
public class SelectAllCustomersTest extends Command.Test<Select>{
    public SelectAllCustomersTest() {
        super(Sakila.CUSTOMERS.selectAll());
    }
}
