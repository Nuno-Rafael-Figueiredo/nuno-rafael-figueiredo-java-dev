package sakila.model;

import mysql.Table;

/**
 * User: Nuno
 * Date: 05-09-2013
 * Time: 16:41
 */
public abstract class SakilaTable extends Table {
    protected SakilaTable(){
        super(Sakila.INSTANCE);
    }

    public abstract SakilaTable instance();
}
