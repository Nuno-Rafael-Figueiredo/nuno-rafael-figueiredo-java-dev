package mysql.operators;

import design.Base;
import design.NamingPolicy;

import java.text.MessageFormat;

/**
 * User: Nuno
 * Date: 04-08-2013
 * Time: 18:36
 */
public abstract class Operator extends Base implements IOperator {
    @Override
    public String pattern() {
        return pattern;
    }

    public enum Type {
        leftUnary, rightUnary, binary, leftBinary, ternary
    }

    public final Type type;
    public final int precedence;
    public final String[] signs;
    public final String pattern;

    protected Operator(Type type, int precedence, String... signs) {
        super(NamingPolicy.asIs);
        this.type = type;
        this.precedence = precedence;
        this.signs = signs.length == 0 ? new String[]{name} : signs;
        switch (type) {
            case leftUnary:
                pattern = MessageFormat.format("{0} '{0'}", this.signs[0]);
                break;
            case rightUnary:
                pattern = MessageFormat.format("'{0'} {0}", this.signs[0]);
                break;
            case ternary:
                pattern = MessageFormat.format("'{0'} {0} '{1'} {1} '{2'}", this.signs[0], this.signs[1]);
                break;
            case leftBinary:
                pattern = MessageFormat.format("{0} '{0'} '{1'}", this.signs[0]);
                break;
            default:
                pattern = MessageFormat.format("'{0'} {0} '{1'}", this.signs[0]);
                break;
        }
    }
}
