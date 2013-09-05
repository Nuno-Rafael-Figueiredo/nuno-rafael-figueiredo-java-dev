package sakila.model.entities;

import mysql.Column;
import mysql.dataTypes.Int;
import mysql.dataTypes.Timestamp;
import mysql.dataTypes.Varchar;
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

    public Column actorId(){
        return createColumn("actor_id", new Int(), Column.Property.primaryKey, Column.Property.unsigned, Column.Property.autoIncrement);
    }

    public Column firstName(){
        return createColumn("first_name", new Varchar(45), Column.Property.notNull);
    }

    public Column lastName(){
        return createColumn("last_name", new Varchar(45), Column.Property.notNull);
    }

    public Column lastUpdate(){
        return createColumn("last_update", new Timestamp(), Column.Property.notNull);
    }
}
