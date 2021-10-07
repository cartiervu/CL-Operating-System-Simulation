/*
    This class implements the Comparator<T> class that helps the java.util.Collections class sort
    an ArrayList<App> by their processID in ascending order.
 */

import java.util.Comparator;

public class ProcessIDComparator implements Comparator<App> {
    /**
     * Compares the processID of the object App
     * @param firstApp      The first App being compared
     * @param secondApp     The second App being compared
     * @return              returns either a positive, negative, or 0 integer indicating how it
     *                      should be sorted
     */
    public int compare(App firstApp, App secondApp) {
        return firstApp.getProcessID() - secondApp.getProcessID();
    }
}
