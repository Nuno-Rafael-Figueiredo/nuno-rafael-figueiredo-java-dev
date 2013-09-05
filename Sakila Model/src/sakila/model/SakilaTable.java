package sakila.model;

import mysql.Table;

/**
 * Created with IntelliJ IDEA.
 * User: Nuno
 * Date: 05-09-2013
 * Time: 16:41
 * To change this template use File | Settings | File Templates.
 */
public abstract class SakilaTable extends Table {
    protected SakilaTable(){
        super(Sakila.INSTANCE);
    }
}
