import sakila.model.tables.Customers;
import design.patterns.command.Command;
import mysql.statements.Select;

/**
 * User: Nuno
 * Date: 28-08-2013
 * Time: 16:19
 */
public class SelectAllCustomersTest extends Command.Test<Select>{
    public SelectAllCustomersTest() {
        super(Customers.INSTANCE.selectAll());
    }
}
