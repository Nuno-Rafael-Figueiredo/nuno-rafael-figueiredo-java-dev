package mysql;

import design.Base;
import design.NamingPolicy;
import mysql.operators.IOperator;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * User: Nuno
 * Date: 04-08-2013
 * Time: 18:34
 */
public class Condition extends Base {
    private final IOperator operator;
    private final List<Object> operands = new ArrayList<>();

    public Condition(IOperator operator, Object... operands) {
        super(NamingPolicy.asIs);
        this.operator = operator;
        for (Object operand : operands)
            this.operands.add(operand instanceof Column ? operand : new Value(operand));
    }

    @Override
    public String toString() {
        return MessageFormat.format(operator.pattern(), operands.toArray());
    }
}
