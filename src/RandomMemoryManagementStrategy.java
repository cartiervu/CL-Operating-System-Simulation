import java.util.ArrayList;
import java.util.Random;

public class RandomMemoryManagementStrategy {
    private Random rand;
    private long totalMemory;
    private ArrayList<App> activeAppList;

    /**
     * Constructor Method
     * @param seed              The seed used to initialize the Random object
     * @param totalMemory       The total memory the simulated system contains
     * @param activeAppList     The list of apps current active on the simulated OS
     */
    public RandomMemoryManagementStrategy(int seed, long totalMemory,
                                          ArrayList<App> activeAppList) {
        this.rand = new Random(seed);
        this.totalMemory = totalMemory;
        this.activeAppList = activeAppList;
    }

    /**
     * Returns true if the memoryRequired exceeds the totalMemory of the system
     * @param memoryRequired        The memory required to run a specific app
     * @return                      Returns a boolean indicating if the memory required is
     * greater                      than the total memory of the system
     */
    public boolean isGreaterThanMaxMemory(long memoryRequired) {
        return memoryRequired > this.totalMemory;
    }

    /**
     * Returns true if the system current contains more than or equal the amount of memory required
     * @param memoryRequired        The memory required to run a specific app
     * @return                      Returns a boolean indicating if the current system memory is
     *                              greater than or equal to the amount of memoryRequired
     */
    public boolean isEnoughMemoryToRunApp(long memoryRequired) {
        // Calls calculateCurrentMemory() to get the systems current memory
        return calculateCurrentMemory() >= memoryRequired;
    }

    /**
     * Calculates and returns the current memory of the system
     * @return      Returns the current memory of the system
     */
    private long calculateCurrentMemory() {
        // Starts w/ the total memory of the system and decreases it by the amount of memory
        // required by each of the current active apps from the activeAppList
        long currentMemory = this.totalMemory;
        for (int i = 0; i < this.activeAppList.size(); i++) {
            currentMemory -= this.activeAppList.get(i).getMemoryRequired();
        }

        return currentMemory;
    }

    /**
     * Randomly selects an App from the activeAppList to termiante using the Random object
     * @param memoryRequired        The memory required by the app to terminate
     * @return                      Returns an app object from the activeAppList
     */
    public App selectNextTerminateTarget(long memoryRequired) {
        App app = null;
        if (this.activeAppList.size() > 0) {
            int appToTerminate = this.rand.nextInt(this.activeAppList.size());
            app = this.activeAppList.get(appToTerminate);
        }

        return app;
    }
}
