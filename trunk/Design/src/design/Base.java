package design;

import design.patterns.command.ICommand;

import java.text.MessageFormat;
import java.util.Observable;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class Base extends Observable implements ICommand.IClient {

    public final String name;

    protected Base() {
        this(NamingPolicy.asIs);
    }

    protected Base(NamingPolicy... namingPolicies) {
        String name = getClass().getSimpleName();

        for(NamingPolicy namingPolicy : namingPolicies)
        switch (namingPolicy) {
            case clause:
                name = Utils.codify(name).toUpperCase().replace("_", " ");
                break;
            case uppercase:
                name = name.toUpperCase();
                break;
            case singularize:
                name = Inflector.getInstance().singularize(name);
                break;
            case humanize:
                name = Utils.humanize(name);
                break;
            case codify:
                name = Utils.codify(name);
                break;
        }

        this.name = name;
    }

    public Base(String name) {
        this.name = name;
    }

    private static void log(final Base base, Level level, String pattern, final Object... arguments) {
        base.logger.log(level, MessageFormat.format("{0}\n{1}", base, pattern), arguments);
    }

    private static void finest(final Base base, final String pattern,
                               final Object[] arguments) {
        log(base, Level.FINEST, pattern, arguments);
    }

    public static void info(final Base base, final String pattern,
                            final Object... arguments) {
        log(base, Level.INFO, pattern, arguments);
    }

    public static void severe(final Base base, final String pattern,
                              final Object... arguments) {
        log(base, Level.SEVERE, pattern, arguments);
    }

    public static void severe(final Base base, final Throwable thrown,
                              final String pattern, final Object... arguments) {
        log(base,
                Level.SEVERE,
                pattern == null ? null : MessageFormat.format(pattern,
                        arguments), thrown);
    }

    public static void warning(final Base base, final String message,
                               final Object... parameters) {
        log(base, Level.WARNING, message, parameters);
    }

    private transient final Logger logger = Logger.getLogger(getClass()
            .getSimpleName());

    protected void finest(final String pattern, final Object... arguments) {
        finest(this, pattern, arguments);
    }

    protected void info(final String pattern, final Object... arguments) {
        info(this, pattern, arguments);
    }

    protected void severe(final String pattern, final Object... arguments) {
        severe(this, pattern, arguments);
    }

    protected void severe(final Throwable thrown, String pattern, Object... arguments) {
        severe(this, thrown, pattern, arguments);
    }

    protected void warning(final String message, final Object... parameters) {
        warning(this, message, parameters);
    }

    public String toString() {
        return name;
    }
}
