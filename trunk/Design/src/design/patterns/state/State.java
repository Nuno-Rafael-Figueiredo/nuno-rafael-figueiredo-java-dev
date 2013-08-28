package design.patterns.state;

import design.Base;
import design.NamingPolicy;

public class State<TContext extends Context<TContext, TState>, TState extends State<TContext, TState>> extends Base implements IState {

    public State() {
        super(NamingPolicy.humanize);
    }
}
