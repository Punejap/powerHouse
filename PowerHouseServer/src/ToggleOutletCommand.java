
    public class ToggleOutletCommand extends Command {
        public ToggleOutletCommand() {
            super("toggle");
        }

        @Override
        public String helpMessage() {
            return "toggle outlet command issue";
        }

        @Override
        public String run(String cmdInput){
            //add validation
            String name = cmdInput.trim();
            //look at server outlets hashmap, find outlet with matching name

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

