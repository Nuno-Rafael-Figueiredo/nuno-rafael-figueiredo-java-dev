package design.patterns.command.exceptions;

import design.patterns.command.ICommand;

public class CommandException extends Exception {

    /**
     *
     */
    private static final long serialVersionUID = 3677404558939293447L;

    public final ICommand command;

    /**
     * @param message the detail message. The detail message is saved for
     *                later retrieval by the {@link #getMessage()} method.
     */
    public CommandException(final ICommand command, final String message) {
        super(message);
        this.command = command;
    }

}
