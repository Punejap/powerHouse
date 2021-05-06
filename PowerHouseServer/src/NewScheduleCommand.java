public class NewScheduleCommand extends Command{

    public NewScheduleCommand() {
        super("new");
    }

    @Override
    public String helpMessage() {
        return "new Schedule Command class issue";
    }

    @Override
    public String run(String cmdInput){
        String scheduleParams = cmdInput.trim();
        int timer;
        String time, days, repeat, action;

        try {
            timer = Integer.parseInt(scheduleParams.substring(0, 1));
            time = scheduleParams.substring(1, 6).trim();
            days = scheduleParams.substring(6, 13);
            repeat = scheduleParams.substring(13, 14);
            action = scheduleParams.substring(14);
            Schedule schedule = new Schedule(timer, time, days, repeat, action);
            PowerHouseServer.scheduleMap.put(timer,  schedule);
            return "schedule created";
        }
        catch(Exception e){return helpMessage();}
    }

}
