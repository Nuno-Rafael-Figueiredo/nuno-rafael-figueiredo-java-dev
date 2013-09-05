package design.patterns.command;

import design.patterns.state.IState;

import java.io.Serializable;
import java.util.Map;

public interface ICommand<TResult> extends Serializable, IState.IContext {
    public static interface IClient {
    }

    void execute();

    void invoke();

    boolean isValid();

    void setParameterMap(Map<String, String[]> parameterMap);

    TResult getResult();
}
