import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Parses input. searches ArrayList children for commands matching the first word of input.
 * Uses recursion to parse each word from command input and find matches
 */
public abstract class Command implements Runnable {
    private String name;

    //array list stores commands and their nested commands
    protected ArrayList<Command>  children = new ArrayList<>();

    /**
     * @param name names of the commands. input will contain exact matches of names
     */
    public Command(String name) {
        this.name = name;
    }

    /**
     * will be used to produce messages to user when bad input is detected
     */
    public abstract String helpMessage();

    public String run(String cmdInput) throws IOException, ParseException {
        //parse first word and store it as string variable
        int index = cmdInput.indexOf(" ");
        if(index == -1){
            index = cmdInput.length();
        }
        String firstWord = cmdInput.substring(0, index);

        //check children to look for commands matching the created string
        for (Command command : children) {
            //find match, pass command to child's run method
            if (command.name.equals(firstWord)) {
                //get rest of command string minus first word
                //pass to command's run method
                String restOf = null;
                if(index <cmdInput.length()){
                    restOf = cmdInput.substring(index + 1, cmdInput.length());
                }
                return command.run(restOf);
            }
        }
        return "bad input";
    }

    public String getName() {
        return name;
    }

}

