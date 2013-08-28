package design.patterns.command;

import design.Base;
import design.patterns.exceptions.SingletonException;

public class Invoker extends Base {

    private static Invoker INSTANCE;

    public static Invoker getInstance() {
        if (INSTANCE == null)
            INSTANCE = new Invoker();

        return INSTANCE;
    }

    protected Invoker() {
        if (INSTANCE != null)
            throw new SingletonException();

        INSTANCE = this;
    }

    public void invoke(final Command command) {
        command.execute();
    }
}
