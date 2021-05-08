import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.ArrayList;

public abstract class Command implements Runnable {
    private String name;
    protected ArrayList<Command>  children = new ArrayList<>();

    public Command(String name) {
        this.name = name;
    }

    public abstract String helpMessage();

    public String run(String cmdInput) throws IOException, ParseException {
        //chop off first part of string, save into variable
        int index = cmdInput.indexOf(" ");
        if(index == -1){
            index = cmdInput.length();
        }
        String firstWord = cmdInput.substring(0, index);

        //check children to look for match
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
        return "command call issue ";
    }

    public String getName() {
        return name;
    }

}

