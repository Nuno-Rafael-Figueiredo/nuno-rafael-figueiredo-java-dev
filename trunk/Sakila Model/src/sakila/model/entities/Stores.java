package sakila.model.entities;

import sakila.model.Sakila;
import sakila.model.SakilaTable;

/**
 * User: Nuno
 * Date: 05-09-2013
 * Time: 16:34
 */
public class Stores extends SakilaTable {
    private Stores(){
    }

    @Override
    public SakilaTable instance() {
        return Sakila.getInstance(name);
    }
}
