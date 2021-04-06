//class for user designed scenes. differs from schedules to control multiple outlets, set
//things like "away from home" mode, turn one outlet off and one on, etc...
//overrides schedule
public class Scene extends Schedule {

    public Scene(String ip) {
        super(ip);
    }

    @Override
    public void executeScene(){

    }

}
