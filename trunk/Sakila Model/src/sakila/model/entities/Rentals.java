package sakila.model.entities;

import sakila.model.Sakila;
import sakila.model.SakilaTable;

/**
 * Created with IntelliJ IDEA.
 * User: Nuno
 * Date: 05-09-2013
 * Time: 16:34
 * To change this template use File | Settings | File Templates.
 */
public class Rentals extends SakilaTable {
    private Rentals(){
    }

    @Override
    public SakilaTable instance() {
        return Sakila.getInstance(name);
    }
}
