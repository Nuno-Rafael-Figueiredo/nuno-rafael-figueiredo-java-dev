package design.patterns.state;

import design.Base;
import design.NamingPolicy;

/**
 * User: Nuno
 * Date: 05-08-2013
 * Time: 4:04
 */
public class Context<TContext extends Context<TContext, TState>, TState extends State<TContext, TState>> extends Base implements IState.IContext {
    protected boolean isState(TState state) {
        return this.state == state;
    }

    public static class Created extends State {
    }

    public static final Created CREATED = new Created();

    protected State state = CREATED;

    public Context() {
    }

    public Context(NamingPolicy namingStrategy) {
        super(namingStrategy);
    }

    public void setState(final TState state) {
        this.state = state;
        finest("{0}: {1}", this, state);
        setChanged();
        notifyObservers(state);
    }

    public Memento save(){
        return new Memento();
    }

    public void restore(Memento memento){
        this.state = memento.state;
    
        setChanged();
        notifyObservers(new MementoRestored(this, memento));
    }

    public class Memento {
        public final TState state;
    
        public Memento() {
            Memento.this.state = (TState) Context.this.state;
        }
    }
}
