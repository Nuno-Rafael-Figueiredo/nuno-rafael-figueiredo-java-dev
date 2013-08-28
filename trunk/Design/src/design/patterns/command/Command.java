package design.patterns.command;

import design.NamingPolicy;
import design.patterns.command.exceptions.NullArgumentException;
import design.patterns.command.states.Aborted;
import design.patterns.command.states.Finished;
import design.patterns.command.states.Started;
import design.patterns.state.Context;
import org.testng.annotations.Test;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertTrue;

public abstract class Command extends Context<Command, Command.State> implements ICommand {

    public static class State extends design.patterns.state.State<Command, State> {
    }

    public static abstract class Test<T extends Command> {
        private T command;
        private State expectedState;

        protected Test(T command) {
            this(command, FINISHED);
        }

        protected Test(T command, State expectState) {
            this.command = command;
            this.expectedState = expectState;
        }

        @org.testng.annotations.Test
        public void testExecute() {
            command.execute();
            assertTrue(command.isState(expectedState));
        }
    }

    private static final long serialVersionUID = -591400853365568418L;

    public static final Started STARTED = new Started();
    public static final Aborted ABORTED = new Aborted();
    public static final Finished FINISHED = new Finished();

    protected final String[] mandatory;
    protected final String[] optional;
    protected final transient Map<String, Object> arguments = new LinkedHashMap<>();

    protected Command(final String... mandatory) {
        this(mandatory, new String[]{});
    }

    protected Command(final String[] mandatory, final String... optional) {
        this(NamingPolicy.asIs, mandatory, optional);
    }

    public Command(NamingPolicy namingStrategy, String[] mandatory, String... optional) {
        super(namingStrategy);
        this.mandatory = mandatory;
        this.optional = optional;
    }

    public Command(NamingPolicy namingStrategy, String... mandatory) {
        this(namingStrategy, mandatory, new String[]{});
    }

    protected void addArgument(final String key, final Object value) {
        arguments.put(key, value);
    }

    @Override
    public final void execute() {
        setState(STARTED);
        populateAttributes();

        for (final String arg : mandatory)
            if (!arguments.containsKey(arg) || arguments.get(arg) == null) {
                severe(new NullArgumentException(this, arg), null);
                setState(ABORTED);

                return;
            }

        if (!isValid()) {
            setState(ABORTED);
            return;
        }

        protectedExecute();
        setState(FINISHED);
        info("{0}", this);
    }

    @Override
    public void invoke() {
        Invoker.getInstance().invoke(this);
    }

    protected void populateAttributes() {
    }

    protected abstract void protectedExecute();

    @Override
    public void setParameterMap(final Map<String, String[]> map) {
        final List<String> list = asList(mandatory);

        list.addAll(asList(optional));

        warning("{0}.setParameterMap - mandatory: {1}", getClass()
                .getSimpleName(), list.size());

        for (final String key : list)
            if (map.containsKey(key) && map.get(key).length == 1) {
                addArgument(key, map.get(key)[0]);
                warning("Argumento `{0}` = `{1}`", key, map.get(key)[0]);
            }
    }
}
