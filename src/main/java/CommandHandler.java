public class CommandHandler {

    private Command cmd = Command.CDM_UNKNOWN;
    private String fullCommand;

    // this is a constructor
    public CommandHandler(String fullCommandText) {
        // as every good constructor does, it constructs stuff for us
        this.fullCommand = fullCommandText;
    }

    // extract a user's name from the command
    public String grabUserName() {
        String name = fullCommand.substring(0, fullCommand.indexOf(" "));
        return name;
    }

    // extract a followee's name from the command
    public String grabFolloweeName() {
        String name = fullCommand.substring(fullCommand.lastIndexOf("follows") + 8);
        return name;
    }

    // extract the message text from the command
    public String grabMessageText() {
        String msg = fullCommand.substring(fullCommand.lastIndexOf("->") + 3);
        return msg;
    }

    // make sense of the command input
    public Command translate(String userInput) {

        // commands with a space in between
        if (userInput.contains(" ")) {
            // commands with a space and an arrow "->" in between
            if (userInput.substring(userInput.indexOf(" ") + 1, userInput.indexOf(" ") + 3).equals("->")) {
                this.cmd = Command.CMD_POST;
                // commands with the word "wall" in between
            } else if (userInput.substring(userInput.indexOf(" ") + 1, userInput.indexOf(" ") + 5).equals("wall")) {
                this.cmd = Command.CMD_WALL;
                // what's left? commands with the word "follows" in between
            } else {
                this.cmd = Command.CMD_FOLLOW;
            }
            // commands without a space in between
        } else {
            // the actual exit command
            if (userInput.toLowerCase().equals("exit")) {
                this.cmd = Command.CMD_EXIT;
                // command for reading a specific wall
            } else {
                this.cmd = Command.CMD_READ;
            }
        }

        return this.cmd;
    }
}