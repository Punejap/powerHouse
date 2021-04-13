//this class will contain methods and fields to create custom schedules for components based on time
//ex. set schedule for outdoor lights, turn specific components off during sleeping hours

public class Schedule implements CreateScene {

    protected String timeOn;
    protected String timeOff;

    //schedules could be considered scenes, but a scene contains much more info
    @Override
    public void executeScene() {

    }
}
