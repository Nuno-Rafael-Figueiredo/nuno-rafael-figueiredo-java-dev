package sakila.model.entities;

import mysql.Table;
import sakila.model.SakilaTable;

/**
 * Created with IntelliJ IDEA.
 * User: Nuno
 * Date: 05-09-2013
 * Time: 16:26
 * To change this template use File | Settings | File Templates.
 */
public class Customers extends SakilaTable {
    public static final Customers INSTANCE = new Customers();

    private Customers(){
    }
}
