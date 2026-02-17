public enum CommandOptions {
    ADD("add"),
    UPDATE("update"),
    DELETE("delete"),
    QUIT("quit"),

    MARK_IN_PROGRESS("mark-in-progress"),
    MARK_DONE("mark-done"),;

//    LIST("list"),
//    LIST_DONE("list done"),
//    LIST_TODO("list todo"),
//    LIST_IN_PROGRESS("list in-progress");

    private final String decision;

    CommandOptions(String decision) {
        this.decision = decision;
    }

    public String getDecision() {
        return decision;
    }

    public static CommandOptions getOptionFromString(String input) {
        for (CommandOptions commandOption : values()) {
            if(commandOption.decision.equalsIgnoreCase(input)) return commandOption;
        }
        return null;
    }
}