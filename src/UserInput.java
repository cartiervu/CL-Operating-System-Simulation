/*
    The purpose of this class is to validate commands inputted by the user through the
    SimulatedSystem object.
 */


import java.util.*;

public class UserInput {
    private SimulatedSystem system;

    /**
     * Constructor Method
     * @param system        SimulatedSystem object that runs commands from inputted through
     *                      this class
     */
    public UserInput(SimulatedSystem system) {
        this.system = system;
    }

    /**
     * Runs specific commands inputted by the user
     */
    public void run() {
        Scanner console = new Scanner(System.in);
        boolean exit = false;

        System.out.print("Sim> ");
        while (!exit && console.hasNextLine()) {
            String userCommand = console.nextLine();
            validateCommand(userCommand);
            if (userCommand.equals("exit")) {
                exit = true;
            } else {
                System.out.print("Sim> ");
            }
        }
    }

    /**
     * Validates the command inputted by the user and runs them onto the SimulatedSystem object
     * @param userCommand   The command inputted by the user
     */
    private void validateCommand(String userCommand) {
        if (isValidCommand(userCommand)) {
            String[] userCommandArr = userCommand.split(" ");
            String command = userCommandArr[0].toLowerCase();
            if (command.equals("run")) {
                this.system.runApp(userCommandArr[1], Long.parseLong(userCommandArr[2]));
            } else if (command.equals("stop")) {
                this.system.stopApp(Integer.parseInt(userCommandArr[1]));
            } else if (userCommand.equalsIgnoreCase("list mem")) {
                this.system.listAppsByMemoryRequirement();
            } else if (userCommand.equalsIgnoreCase("list")) {
                this.system.listApps();
            }
        } else {
            System.out.printf("Invalid Command: \"%s\"\n", userCommand);
        }
    }

    /**
     * Returns true if the command is valid
     * @param userCommand       The command inputted by the user
     * @return                  returns a boolean indicating if the command is valid
     */
    private boolean isValidCommand(String userCommand) {
        // The only valid commands are: "run", "stop", "list", and "exit"
        if (userCommand.length() > 0) {
            String[] userCommandArr = userCommand.split(" ");
            switch (userCommandArr[0].toLowerCase()) {
                case "run" :
                    return isValidRunCommand(userCommandArr);
                case "stop" :
                    return isValidStopCommand(userCommandArr);
                case "list" :
                    return isValidListCommand(userCommandArr);
                case "exit" :
                    return true;
                default :
            }
        }

        return false;
    }

    /**
     * Returns true if the userCommand contains a String, long, and int
     * @param userCommandArr        The command inputted by the user formatted into an array
     * @return                      returns a boolean indicating if the "run" command is valid
     */
    private boolean isValidRunCommand(String[] userCommandArr) {
        // The "run" command must contain 3 arguments, the first one being "run", the second
        // being a String, and third one being a valid long
        if (userCommandArr.length == 3) {
                try {
                    return Long.parseLong(userCommandArr[2]) >= 0;
                } catch (Exception e) {
                    return false;
                }
        }

        return false;
    }

    /**
     * Returns true if the userCommand contains an integer argument
     * @param userCommandArr        The command inputted by the user formatted into an array
     * @return                      returns a boolean indicating if the "stop" command is valid
     */
    private boolean isValidStopCommand(String[] userCommandArr) {
        // The "stop" command must contain 2 arguments, the first one being "stop" and the second
        // one being a valid integer
        if (userCommandArr.length == 2) {
            try {
                return Integer.parseInt(userCommandArr[1]) >= 0;
            } catch (NumberFormatException e) {
                return false;
            }
        }

        return false;
    }

    /**
     * Returns true if the userCommand contains "mem" or nothing
     * @param userCommandArr        The command inputted by the user formatted into an array
     * @return                      returns a boolean indicating if the "list" command is valid
     */
    private boolean isValidListCommand(String[] userCommandArr) {
        // The "list" command must contain either 1 or 2 arguments
        if (userCommandArr.length == 1) {
            return true;
        } else if (userCommandArr.length == 2) {
            // Only "list mem" is valid for userCommand list w/ 2 arguments
            if (userCommandArr[1].equalsIgnoreCase("mem")) {
                return true;
            }
        }

        return false;
    }
}
