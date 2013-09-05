package sakila.model.entities;

import sakila.model.Sakila;
import sakila.model.SakilaTable;

/**
 * User: Nuno
 * Date: 05-09-2013
 * Time: 16:25
 */
public class Actors extends SakilaTable {
    private Actors(){
    }

    @Override
    public SakilaTable instance() {
        return Sakila.getInstance(name);
    }
}
