/*
    The purpose of this class is to simulate an operating system. The commands for the operating
    system are "run", "stop", "list", and "exit".
 */

import java.util.ArrayList;
import java.util.Collections;

public class SimulatedSystem {
    private RandomMemoryManagementStrategy rrmStrategy;
    private int maxSystemMemory;
    private ArrayList<App> activeAppList;
    private int appID;

    /**
     * Constructor Method
     * @param rmmStrategy           RandomMemoryManagementStrategy object that randomly
     *                              terminates apps if extra memory is needed
     * @param maxSystemMemory       The maximum memory the system contains
     * @param activeAppList         ArrayList of App objects that are currently active on the
     *                              simulated system
     */
    public SimulatedSystem(RandomMemoryManagementStrategy rmmStrategy,
                           int maxSystemMemory,
                           ArrayList<App> activeAppList) {
        this.rrmStrategy = rmmStrategy;
        this.maxSystemMemory = maxSystemMemory;
        this.activeAppList = activeAppList;
        this.appID = 1;
    }

    /**
     * Runs apps (only if they meet the memory requirements) by adding them to the instance
     * variable activeAppList
     * @param appName           The name of the app that is being run
     * @param memoryRequired    The amount of memory required to run app
     */
    public void runApp(String appName, long memoryRequired) {
        // Checks to see if the app requires more memory than the system contains
        if (this.rrmStrategy.isGreaterThanMaxMemory(memoryRequired)) {
            System.out.printf("Not enough memory to run %s\n", appName);
        } else {
            // Uses the RandomMemoryManagementStrategy to terminate random apps in order to run
            // the new one
            while (!this.rrmStrategy.isEnoughMemoryToRunApp(memoryRequired)) {
                this.terminate(this.rrmStrategy.selectNextTerminateTarget(memoryRequired));
            }

            // Adds the new app on to the activeAppList
            this.activeAppList.add(new App(appName, memoryRequired, this.appID));
            System.out.println("Started " + this.appID++); // Prints and increments appID
        }
    }

    /**
     * Termiates a specific active app
     * @param app       The app that is being termianted
     */
    private void terminate(App app) {
        this.activeAppList.remove(app);
        System.out.printf("Terminated %d\n", app.getProcessID());
    }

    /**
     * Stops specific app given the appID
     * @param appID     The appID of the app that is being stopped
     */
    public void stopApp(int appID) {
        // Checks to see if the activeAppList contains the appID
        for (int i = 0; i < this.activeAppList.size(); i++) {
            if (this.activeAppList.get(i).getProcessID() == appID) {
                this.activeAppList.remove(i);
                System.out.printf("Stopped %d\n", appID);
                break;
            }
        }

    }

    /**
     * Lists all apps from the ArrayList activeAppList based on their processID in ascending order
     */
    public void listApps() {
        // Calls Collections.sort method, placing a ProcessIDComparator object in it
        Collections.sort(this.activeAppList, new ProcessIDComparator());
        for (int i = 0; i < this.activeAppList.size(); i++) {
            System.out.printf("%d %s\n",
                    this.activeAppList.get(i).getProcessID(),
                    this.activeAppList.get(i).getName());
        }
    }

    /**
     * Lists all apps from the ArrayList activeAppList based on their memoryRequired in descending
     * order
     */
    public void listAppsByMemoryRequirement() {
        // Calls Collections.sort method, placing a MemoryRequirementComparator object in it
        Collections.sort(this.activeAppList, new MemoryRequirementComparator());
        for (int i = 0; i < this.activeAppList.size(); i++) {
            System.out.printf("%d %s\n",
                    this.activeAppList.get(i).getMemoryRequired(),
                    this.activeAppList.get(i).getName());
        }
    }
}
