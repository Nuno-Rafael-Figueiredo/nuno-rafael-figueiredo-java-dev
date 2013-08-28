package design.patterns.command;

import design.patterns.state.StateChanged;

import java.util.*;

public abstract class Wizard extends Command implements Observer {

    /**
     *
     */
    private static final long serialVersionUID = 4719271959020020388L;

    private final List<Command> steps = new ArrayList<>();

    protected Wizard(Command first, Command second, Command... others) {
        steps.add(first);
        steps.add(second);
        steps.addAll(Arrays.asList(others));
    }

    @Override
    protected void protectedExecute() {
        invokeStep();
    }

    @Override
    public void update(final Observable o, final Object arg) {
        if (arg instanceof StateChanged) {
            final StateChanged stateChanged = (StateChanged) arg;

            if (stateChanged.newState == ABORTED)
                setState(ABORTED);
            else if (stateChanged.newState == FINISHED)
                invokeStep();
        }
    }

    private void invokeStep() {
        if (steps.size() == 0) {
            setState(FINISHED);
            return;
        }

        final Command step = steps.remove(0);

        step.addObserver(this);

        step.invoke();
    }

    @Override
    public boolean isValid() {
        return true;
    }

    public void testCoiso(){

    }
}
