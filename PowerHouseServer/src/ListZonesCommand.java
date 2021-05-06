import org.json.simple.JSONObject;

import java.util.ArrayList;

public class ListZonesCommand extends Command{

    public ListZonesCommand() {
        super("list");
    }

    @Override
    public String helpMessage() {
        return "list zone command issue";
    }

    public String run(String cmdInput) {

        //look at server outlets hashmap, find outlet with matching name


        return JSONObject.toJSONString(PowerHouseServer.zoneMap);
    }

    }


