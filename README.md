# Operating-System-Simulation

### Specification
The simulator takes user input through the command line and accepts 4 different commands:
1. Run App `run <App Name> <Memory Requirement>`
2. Stop App `stop <App ID>`
3. List All Running Apps `list pid|mem`
4. Exit System `exit`

### Run App
**Command:** `run <App Name> <Memory Requirement>`

If the new app requires more memory than the system's total memory, it should not terminate any app and print:

&nbsp;&nbsp;&nbsp;&nbsp;`Not enough memory to run <App Name>`

If there's not enough memory currently, it should follow the [selected memory management system](#memory-management-systems) to terminate the apps until there is sufficient memory to start the app. Terminated apps print:

&nbsp;&nbsp;&nbsp;&nbsp;`Terminated <App ID>`

When there is enough memory to run app, the system would generate a new process ID for this app and add the app to the system's active app list and prints:

&nbsp;&nbsp;&nbsp;&nbsp;`Started <App ID>`

### Stop App
**Command:** `stop <App ID>`

If <App ID> is an active app, that app will be removed from the system's active list and prints:

&nbsp;&nbsp;&nbsp;&nbsp;`Stopped <App ID>`

### List All Running Apps
**Command:** `list`

Prints all active apps. For example:

&nbsp;&nbsp;&nbsp;&nbsp;`1 Excel`

&nbsp;&nbsp;&nbsp;&nbsp;`2 Minesweeper`

&nbsp;&nbsp;&nbsp;&nbsp;`3 File Manager`

### Exit
**Command:** `exit`

Exits the system.
