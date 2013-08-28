package design.patterns.state;

import design.Base;

public class StateChanged extends Base {

    public final Context context;
    public final IState oldState;
    public final IState newState;

    public StateChanged(final Context context, final IState oldState,
                        final IState newState) {
        this.context = context;
        this.oldState = oldState;
        this.newState = newState;
    }

}
