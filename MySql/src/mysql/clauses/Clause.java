package mysql.clauses;

import design.Base;
import design.NamingPolicy;
import mysql.statements.Statement;

/**
 * User: Nuno
 * Date: 04-08-2013
 * Time: 18:08
 */
public abstract class Clause<E extends Statement> extends Base {
    protected final E statement;
    private boolean used = false;

    protected Clause(E statement) {
        this(statement, false);
    }

    public Clause(String name, E statement, boolean required) {
        super(name);
        this.statement = statement;
        this.statement.add(this);

        if (required)
            setUsed();
    }

    public Clause(E statement, boolean required) {
        super(NamingPolicy.clause);
        this.statement = statement;
        this.statement.add(this);

        if (required)
            setUsed();
    }

    protected void setUsed() {
        if (!used)
            statement.setUsed(this);
        used = true;
    }

}
