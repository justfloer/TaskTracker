public enum CommandOptions {
    ADD("add"),
    UPDATE("update"),
    DELETE("delete"),
    COMMANDS("commands"),

    MARK_IN_PROGRESS("mark-in-progress"),
    MARK_DONE("mark-done"),

    LIST("list");

    private final String decision;

    CommandOptions(String decision) {
        this.decision = decision;
    }

    public static CommandOptions getOptionFromString(String input) {
        for (CommandOptions commandOption : values()) {
            if(commandOption.decision.equalsIgnoreCase(input)) return commandOption;
        }
        return null;
    }
}