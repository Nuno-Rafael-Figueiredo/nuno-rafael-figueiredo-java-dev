package mysql;

import design.Base;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/**
 * User: Nuno
 * Date: 02-09-2013
 * Time: 14:58
 */
public class Key extends Base implements Iterable<Column>{
    private List<Column> columns = new ArrayList<>();

    @Override
    public Iterator<Column> iterator() {
        return columns.iterator();
    }

    protected void add(Column column) {
        columns.add(column);
    }
}
