import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.ArrayList;

public class CreateScheduleCommand extends Command{

    public CreateScheduleCommand() {
        super("create");
    }

    @Override
    public String helpMessage() {
        return "Set Schedule Command class issue";
    }

    @Override
    public String run(String cmdInput){
        String scheduleParams = cmdInput.trim();
        int timer;
        String time, days, repeat, action;

        timer = Integer.parseInt(scheduleParams.substring(0, 1));
        time = scheduleParams.substring(1, 6);
        days = scheduleParams.substring(6, 13);
        repeat = scheduleParams.substring(13, 14);
        action = scheduleParams.substring(14);
       PowerHouseServer.scheduleList[timer] = new Schedule(timer, time, days, repeat, action);
        return "timer created";
    }

}
