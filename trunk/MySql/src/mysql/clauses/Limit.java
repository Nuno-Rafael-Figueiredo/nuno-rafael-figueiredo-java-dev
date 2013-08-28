package mysql.clauses;

import mysql.statements.Statement;

/**
 * User: Nuno
 * Date: 04-08-2013
 * Time: 19:48
 */
public class Limit<TStatement extends Statement> extends Clause<TStatement> {
    private Integer offset;
    private Integer rowCount;

    public Limit(TStatement statement) {
        super(statement);
    }

    public TStatement set(int offset, int rowCount) {
        setUsed();
        setOffset(offset);
        setRowCount(rowCount);

        return statement;
    }

    void setOffset(int offset) {
        setUsed();
        this.offset = offset;
    }

    void setRowCount(int rowCount) {
        setUsed();
        this.rowCount = rowCount;
    }

    @Override
    public String toString() {
        if (offset == null)
            return super.toString() + " " + rowCount;
        return super.toString() + " " + offset + ", " + rowCount;
    }
}
