package mysql;

import design.Utils;
import design.patterns.state.Context;
import mysql.states.Opened;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MySql extends Context<MySql, MySql.State> {
    private Connection connection;

    public static class State extends design.patterns.state.State<MySql, State> {

    }

    private static final Opened OPENED = new Opened();

    private static final String SERVER = "localhost";
    private static final String DB_NAME = "mydb";
    private static final String USERNAME = Utils.get("username", "root");
    private static final String PASSWORD = Utils.get("password", "");

    public static final DateFormat DATE_FORMAT = new SimpleDateFormat(
            "yyyy-MM-dd");

    private static final String URL = "jdbc:mysql0://" + SERVER + "/" + DB_NAME
            + "?user=" + USERNAME + "&password=" + PASSWORD;

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
