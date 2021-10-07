/*
    Cartier Vu
    ID: 100296371
    CPSC 1181 SEC 4
    05/31/19

    This class implements the Comparator<T> class that helps the java.util.Collections class sort
    an ArrayList<App> by their memoryRequired in descending order.
 */

import java.util.Comparator;

public class MemoryRequirementComparator implements Comparator<App> {
    /**
     * Compares two App object's memoryRequired
     * @param firstApp      The first App being compared
     * @param secondApp     The second App being compared
     * @return
     */
    public int compare(App firstApp, App secondApp) {
        return (int)((firstApp.getMemoryRequired() - secondApp.getMemoryRequired()) * -1);
    }
}
