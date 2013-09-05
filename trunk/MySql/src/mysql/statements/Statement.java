package mysql.statements;

import design.NamingPolicy;
import design.Utils;
import design.patterns.command.Command;
import mysql.MySql;
import mysql.clauses.Clause;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

/**
 * User: Nuno
 * Date: 04-08-2013
 * Time: 18:01
 */
public abstract class Statement extends Command implements IStatement {
    private final TreeMap<Integer, Clause> usedClauses = new TreeMap<>();
    private final List<Clause> allClauses = new ArrayList<>();

    protected Statement() {
        super(NamingPolicy.uppercase);
    }

    protected Statement(String name) {
        super(name);
    }

    public void setUsed(Clause clause) {
        usedClauses.put(allClauses.indexOf(clause), clause);
    }

    @Override
    public String toString() {
        return super.toString() + " " + Utils.join(usedClauses.values().toArray(), " ");
    }

    public void add(Clause clause) {
        allClauses.add(clause);
    }
}
