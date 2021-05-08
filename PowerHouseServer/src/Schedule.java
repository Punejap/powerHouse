//this class will contain methods and fields to create custom schedules for components based on time
//ex. set schedule for outdoor lights, turn specific components off during sleeping hours

import org.json.simple.JSONObject;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class Schedule{

    public int timer;
    public String time, days, repeat, action;

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
