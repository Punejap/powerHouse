/**
 * used to create schedules and store them in HashMap scheduleMap
 * input command structure: schedule new (schedule number 1-10)(24 hr time)(7days)(repeat)(action)
 * ex: schedule new 309:30111110011 creates schedule 3 for 9:30 am, enabled SMTWTh, disabled FS, repeats, turns on
 */
public class NewScheduleCommand extends Command {

    public NewScheduleCommand() {
        super("new");
    }

    public String helpMessage() {
        return "new Schedule Command class issue";
    }

    //parse all parameters, instantiate and initialize schedule object. store in scheduleMap
    public String run(String cmdInput){
        String scheduleParams = cmdInput.trim();
        int timer;
        String time, days, repeat, action;

        if(scheduleParams.length() <= 15){
            timer = Integer.parseInt(scheduleParams.substring(0, 1));
            time = scheduleParams.substring(1, 6).trim();
            days = scheduleParams.substring(6, 13);
            repeat = scheduleParams.substring(13, 14);
            action = scheduleParams.substring(14);
            Schedule schedule = new Schedule(timer, time, days, repeat, action);
            PowerHouseServer.scheduleMap.put(timer,  schedule);
            return "schedule created";
        }
       return helpMessage();
    }

}
