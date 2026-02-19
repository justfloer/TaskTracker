public enum TaskStatus {
    TODO("[ ]"),
    IN_PROGRESS("[!]"),
    DONE("[+]");

    private final String graphicalStatus;

    TaskStatus(String graphicalStatus) {
        this.graphicalStatus = graphicalStatus;
    }

    public String getGraphicalStatus() {
        return graphicalStatus;
    }

}
