/*
    The PSVM class that runs the Operating System program
 */
import java.util.ArrayList;

public class RunSystem {
    public static void main(String[] args) {
        ArrayList<App> activeAppList = new ArrayList<App>();

        RandomMemoryManagementStrategy rmmStrategy = new RandomMemoryManagementStrategy(
                Integer.parseInt(args[1]),
                Integer.parseInt(args[0]),
                activeAppList);

        SimulatedSystem system = new SimulatedSystem(
                rmmStrategy,
                Integer.parseInt(args[0]),
                activeAppList);

        UserInput input = new UserInput(system);
        input.run();
    }
}
