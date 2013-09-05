package mysql;

import design.Utils;
import design.patterns.state.Context;
import mysql.states.Opened;
import mysql.states.Closed;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MySql extends Context<MySql, MySql.State> implements AutoCloseable{
    public Connection connection;
    private DataBase dataBase;

    public static final MySql INSTANCE = new MySql();

    private static final Opened OPENED = new Opened();
    private static final Closed CLOSED = new Closed();

    private static final String SERVER = "localhost";
    private static final String DB_NAME = "mydb";
    private static final String USERNAME = Utils.get("username", "root");
    private static final String PASSWORD = Utils.get("password", "");

    public static final DateFormat DATE_FORMAT = new SimpleDateFormat(
            "yyyy-MM-dd");

    private final String URL = "jdbc:mysql0://" + SERVER + "/" + getDbName()
            + "?user=" + getUsername() + "&password=" + getPassword();

    private MySql(){
    }
    public void setDataBase(DataBase dataBase) {
        this.dataBase = dataBase;
    }

    @Override
    public void close() throws Exception {
        connection = null;

        setState(CLOSED);
    }

    public static class State extends design.patterns.state.State<MySql, State> {
    }

    private String getDbName(){
        return dataBase == null ? DB_NAME : dataBase.toString();
    }

    private String getUsername() {
        return dataBase != null && dataBase.getUsername() != null ? dataBase.getUsername() : USERNAME;
    }

    private String getPassword() {
        return dataBase != null && dataBase.getPassword() != null ? dataBase.getPassword() : PASSWORD;
    }

    public MySql open() throws SQLException {
        try {
            Class.forName("com.mysql0.jdbc.Driver").newInstance();
        } catch (final ReflectiveOperationException e) {
            severe(e, null);
        }

        info("DriverManager.getConnection(URL)");

        connection = DriverManager.getConnection(URL);
        setState(OPENED);

        return this;
    }

    public static String parseDateFromOutputToMysql(final String source)
            throws ParseException {
        final Date date = Utils.dateFormat.parse(source);

        return DATE_FORMAT.format(date);
    }


}
