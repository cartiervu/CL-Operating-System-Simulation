# Operating-System-Simulation

### Specification
The simulator takes user input through the command line and accepts 4 different commands:
1. Run App `run <App Name> <Memory Requirement>`
2. Stop App `stop <App ID>`
3. List All Running Apps `list | list mem`
4. Exit System `exit`

### Run App
**Command:** `run <App Name> <Memory Requirement>`

If the new app requires more memory than the system's total memory, it should not terminate any app and print

&nbsp;&nbsp;&nbsp;&nbsp;`Not enough memory to run <App Name>`

If there's not enough memory currently, it should follow the [selected memory management system](#memory-management-systems) to terminate the apps until there is sufficient memory to start the app. Terminated apps print

&nbsp;&nbsp;&nbsp;&nbsp;`Terminated <App ID>`

When there is enough memory to run app, the system would generate a new process ID for this app and add the app to the system's active app list and prints

&nbsp;&nbsp;&nbsp;&nbsp;`Started <App ID>`


### Use App
**Command:** `use <App ID>`

An app is first used when it was first run, and running the command emulates using the app while also refreshing the last used time of the app

**Example**
> run Excel 10\
  Started 1\
  run Plugin 10 1\
  Started 2\
  use 1

### Stop App
**Command:** `stop <App ID>`

If <App ID> is an active app, that app will be removed from the system's active list and prints

&nbsp;&nbsp;&nbsp;&nbsp;`Stopped <App ID>`

### List All Running Apps
**Command:** `list` or `list mem` 

Prints all active apps (and memory for list mem command)

<table>
<tr>
<th>list</th>
<th>list mem</th>
</tr>
<tr>
<td>
<pre>
1 Excel
2 MineSweeper
3 File Manager
</pre>
</td>
<td>
<pre>
100 Excel
150 MineSweeper
50 File Manager  
</pre>
</td>
</tr>
</table>
  
### Exit
**Command:** `exit`

Exits the system

## Memory Management Systems

### Random Memory Strategy
  
Randomly selects apps from the active app list to terminate until enough memory is freed to run the next app 
  
### Most Memory Strategy
  
Selects the app occupying the most memory from the active app list to terminate until enough memory is freed to run the next app

**Example w/ only 20 system memory**
> run Excel 15\
  Started 1\
  run Plugin 5 1\
  Started 2\
  run MineSweeper 10\
  Terminated 1\
  Terminated 2\
  Started 3
  
### Least Recently Used

Selects the app that was least recently used from the acitve app list to termiante until enough memory is freed to run the next app
  
**Example w/ only 20 system memory**
> run Excel 10\
  Started 1\
  run Plugin 10 1\
  Started 2\
  use 1\
  run MineSweeper 10\
  Terminated 2
  
