package sakila.model;

import design.NamingPolicy;
import mysql.DataBase;
import sakila.model.entities.Customers;
import sakila.model.entities.FilmTexts;

import java.util.LinkedHashMap;
import java.util.Map;

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

    private static final Map<String, SakilaTable> instances = new LinkedHashMap<>();

    public static synchronized SakilaTable getInstance(String key) {
        SakilaTable instance = instances.get(key);

        if (instance == null) {
            instance = SakilaTableFactory.INSTANCE.create(key);

            instances.put(key, instance);
        }

        return instance;
    }
}
