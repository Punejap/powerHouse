//ex. set schedule for outdoor lights, turn specific components off during sleeping hours

import org.json.simple.JSONObject;

/**
 * contains parameters for schedules in the form of variables. returns information in JSON format
 */
public class Schedule{

    public int timer;
    public String time, days, repeat, action;

    /**
     * @param timer schedule number, designates the schedule, must be 1 to 9
     * @param time must be in 24:00 format
     * @param days 7 digits sunday to saturday, 0 and - disable, 1 and chars enable
     * @param repeat if 1, schedule action will repeat; if 0, schedule action occurs once
     * @param action 0 disables power output, 1 enables power output
     */
    public Schedule(int timer, String time, String days, String repeat, String action) {
        this.timer = timer;
        this.time = time;
        this.days = days;
        this.repeat = repeat;
        this.action = action;
    }

    //schedules could be considered scenes, but a scene contains much more info
    public String createSettings(){
        JSONObject obj = new JSONObject();
        obj.put("Time", this.getTime());
        obj.put("Days",this.getDays());
        obj.put("Repeat", this.getRepeat());
        obj.put("Action", this.getAction());
        
        return JSONObject.toJSONString(obj);
    }

    public int getTimer() {
        return timer;
    }

    public void setTimer(int timer) {
        this.timer = timer;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDays() {
        return days;
    }

    public void setDays(String days) {
        this.days = days;
    }

    public String getRepeat() {
        return repeat;
    }

    public void setRepeat(String repeat) {
        this.repeat = repeat;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }
}
