/**
 * contains method to toggle existing outlet
 * input command structure: outlets toggle (outlet name)
 */
    public class ToggleOutletCommand extends Command {
        public ToggleOutletCommand() {
            super("toggle");
        }

        public String helpMessage() {
            return "toggle outlet command issue";
        }

        public String run(String cmdInput){
            //add validation
            String name = cmdInput.trim();

            //look at server outlets hashmap, find outlet with matching name. execute outlet.toggle();
            try {
                Outlet outlet = PowerHouseServer.outletMap.get(name);
                outlet.togglePower();
            }
            catch(Exception e){
                return helpMessage();
            }
            return "i just toggled outlet " + name;
        }
    }

