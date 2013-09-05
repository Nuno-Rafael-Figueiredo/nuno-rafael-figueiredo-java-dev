package sakila.model;

import design.NamingPolicy;
import mysql.DataBase;
import sakila.model.entities.Customers;
import sakila.model.entities.FilmTexts;

/**
 * User: Nuno
 * Date: 05-09-2013
 * Time: 16:35
 */
public class Sakila extends DataBase {
    public static final Sakila INSTANCE = new Sakila();

    public static final Customers CUSTOMERS = Customers.INSTANCE;
    public static final FilmTexts FILM_TEXTS = FilmTexts.INSTANCE;

    private Sakila() {
        super(NamingPolicy.uppercase, NamingPolicy.singularize, NamingPolicy.codify, NamingPolicy.uppercase);
        setUsername("root");
        setPassword("root");
    }

}
