/*
    The purpose of this class is to hold data about the current App being run within the
    SimulatedSystem class.
 */

public class App {
    private String name;
    private long memoryRequired;
    private int processID;

    /**
     * Constructor Method
     * @param name              The name of the App
     * @param memoryRequired    The amount of memory required to run the app
     * @param processID         The process ID to identify the app
     */
    public App(String name, long memoryRequired, int processID) {
        this.name = name;
        this.memoryRequired = memoryRequired;
        this.processID = processID;
    }

    public String getName() {
        return this.name;
    }

    public long getMemoryRequired() {
        return this.memoryRequired;
    }

    public int getProcessID() {
        return this.processID;
    }
}
