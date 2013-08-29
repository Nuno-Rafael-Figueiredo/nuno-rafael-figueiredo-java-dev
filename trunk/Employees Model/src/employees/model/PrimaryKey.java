package employees.model;

import design.Base;
import mysql.Column;

import java.util.ArrayList;
import java.util.List;

/**
 * User: Nuno
 * Date: 29-08-2013
 * Time: 12:07
 */
public class PrimaryKey extends Base {
    private final List<Column> columns = new ArrayList<>();

    public PrimaryKey set(Column column) {


        return this;
    }
}
