import design.patterns.command.Command;
import mysql.statements.Select;
import sakila.model.Sakila;

/**
 * User: Nuno
 * Date: 28-08-2013
 * Time: 16:19
 */
public class SelectAllFilmTextsTest extends Command.Test<Select>{
    public SelectAllFilmTextsTest() {
        super(Sakila.FILM_TEXTS.selectAll());
    }
}
